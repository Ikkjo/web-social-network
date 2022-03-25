Vue.component("user-search-result", {
    props: ["user"],
    data() {
        return {
            isFriend: false,
        }
    },
    template: `
    <div class="flex-container user-search-result-container">
        <user-thumbnail :user="user"></user-thumbnail>
        <button v-if="!isFriend" @click="sendFriendRequest" class="btn user-search-result-btn"><i class="fas fa-user-plus"></i></button></a>
        <button v-if="isFriend" @click="sendMessage" class="btn user-search-result-btn"><i class="fas fa-comment-dots"></i></button></a>
    </div>
    `,
    methods: {
        sendFriendRequest() {
            console.log("Friend request sent...");
        },
        sendMessage() {
            console.log("Sending message...");
        },
    },
    mounted() {
        // Add check for isFriend parameter using the logged in user
        if (window.sessionStorage.getItem("user")) {
            username = JSON.parse(window.sessionStorage.getItem("user")).username;
            token = JSON.parse(window.sessionStorage.getItem("user")).jwt
            axios.get("/are-friends", {
                headers: {
                    Authorization: 'Bearer ' + token,
                },
                params: {
                    username1: username,
                    username2: this.user.username,
                }
            }).then((response) => this.isFriend = response.data)
            .catch(() => alert("Greška."));
        }
        else
            this.isFriend = false;
    },
});
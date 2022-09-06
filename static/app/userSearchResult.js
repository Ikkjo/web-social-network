Vue.component("user-search-result", {
    props: ["user"],
    data() {
        return {
            isFriend: false,
            loggedInUser: null,
        }
    },
    template: `
    <div class="flex-container user-search-result-container">
        <user-thumbnail :user="user" :useEmail="user && user.type='admin'"></user-thumbnail>
        <button v-if="loggedInUser && loggedInUser.type==='regular' !isFriend" @click="sendFriendRequest" class="btn user-search-result-btn"><i class="fas fa-user-plus"></i></button></a>
        <button v-if="loggedInUser && ((loggedInUser.type==='regular' && isFriend) || loggedInUser.type==='admin')" @click="sendMessage" class= "btn user-search-result-btn"><i class="fas fa-comment-dots"></i></button></a>
        <button v-if="loggedInUser && loggedInUser.type==='admin' && user.blocked === false" @click="block" class= "btn user-search-result-btn ban-btn"><i class="fas fa-ban"></i></button></a>
        <button v-if="loggedInUser && loggedInUser.type==='admin && user.blocked === true'" @click="unblock" class= "btn user-search-result-btn"><i class="far fa-check-circle"></i></button></a>
    </div>
    `,
    methods: {
        sendFriendRequest() {
            console.log("Friend request sent...");
        },
        sendMessage() {
            console.log("Sending message...");
        },
        block() {
            // TODO: PUT request for blocking user
            this.user.blocked = true;
        },
        unban() {
            // TODO: PUT request for unblocking user
            this.user.blocked = false;
        }
    },
    mounted() {
        // Add check for isFriend parameter using the logged in user
        if (window.sessionStorage.getItem("user")) {
            this.loggedInUser = JSON.parse(window.sessionStorage.getItem("user"))
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
        } else
            this.isFriend = false;
    },
});
Vue.component("user-search-result", {
    props: ["user"],
    data() {
        return {
            isFriend: true,
        }
    },
    template: `
    <div class="container user-search-result-container">
        <user-thumbnail :user="user"></user-thumbnail>
        <button v-if="!isFriend" @click="sendFriendRequest" class="btn"><i class="fas fa-sign-out-alt"></i> Odjavi se</button></a>
        <button v-if="isFriend" @click="sendMessage" class="btn"><i class="fas fa-sign-out-alt"></i> Odjavi se</button></a>
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
    mounted() {},
});
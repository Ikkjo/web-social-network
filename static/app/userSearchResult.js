Vue.component("user-search-result", {
    props: ["user"],
    data() {
        return {
            isFriend: false,
        }
    },
    template: `
    <div class="container user-search-result-container">
        <user-thumbnail :user="user"></user-thumbnail>
        <button v-if="!isFriend" @click="sendFriendRequest" class="btn"><i class="fas fa-user-plus"></i> Pošalji zahtev</button></a>
        <button v-if="isFriend" @click="sendMessage" class="btn"><i class="fas fa-comment-dots"></i> Poruka</button></a>
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
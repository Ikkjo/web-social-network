Vue.component("user-thumbnail", {
    props: ["user"],
    data() {
        return {}
    },
    template: `
    <div class="container user-thumbnail-container">
        <img :src="user.profilePic" alt="Profilna slika">
        <p>{{user.name}} {{user.surname}}</p>
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
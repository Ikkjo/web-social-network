Vue.component("user-thumbnail", {
    props: ["user"],
    data() {
        return {}
    },
    template: `
    <div class="container user-thumbnail-container">
        <img :src="user.profilePic" alt="Profilna slika">
        <h2>{{user.name}}</h2>
        <h2>{{user.surname}}</h2>
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
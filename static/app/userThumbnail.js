Vue.component("user-thumbnail", {
    props: ["user"],
    data() {
        return {}
    },
    template: `
    <div class="container user-thumbnail-container">
        <img :src="user.profilePic" alt="Profilna slika">
        <h3>{{user.name}} {{user.surname}}</h3>
        <span>(01.01.2000.)</span>
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
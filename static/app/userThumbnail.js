Vue.component("user-thumbnail", {
    props: ["user"],
    data() {
        return {
            date: null,
        }
    },
    template: `
    <div class="flex-container user-thumbnail-container">
        <img :src="user.profilePic" alt="Profilna slika">
        <h3>{{user.name}} {{user.surname}}</h3>
        <span>{{date}}</span>
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
        this.date = JSON.stringify(new Date(this.user.dateOfBirth)).split("-");
        this.date = date[2].split("T")[0] + "." + date[1] + "." + date[0].substring(1)+".";
    },
});
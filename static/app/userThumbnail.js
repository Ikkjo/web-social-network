Vue.component("user-thumbnail", {
    props: ["user"],
    data() {
        return {
            date: null,
        }
    },
    template: `
    <div class="flex-container user-thumbnail-container">
        <router-link :to="/user/+user.username"><img :src="user.profilePic" alt="Profilna slika"></router-link>
        <router-link :to="/user/+user.username" class="fullname">{{user.name}} {{user.surname}}</router-link>
        <span>({{date}})</span>
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
        this.date = JSON.stringify(new Date(this.user.dateOfBirth.year + '-' + this.user.dateOfBirth.month + '-' +this.user.dateOfBirth.day));
        this.date = this.date.replace(/\"|T.*/g, "").split("-");
        this.date = this.date[2] + "." + this.date[1] + "." + this.date[0];
    },
});
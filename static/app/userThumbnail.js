Vue.component("user-thumbnail", {
    props: {
        user: {
            type: Object,
        },
        useDate: {
            type: Boolean,
            default: true,
        }
    },
    data() {
        return {
            date: null,
        }
    },
    template: `
    <div class="flex-container user-thumbnail-container">
        <router-link :to="/user/+user.username" class="profile-pic"><img :src="user.profilePic" alt="Profilna slika"></router-link>
        <router-link :to="/user/+user.username" class="fullname">{{user.name}} {{user.surname}}</router-link>
        <span v-if="useDate">({{date}})</span>
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
        if (this.useDate) {
            this.date = JSON.stringify(new Date(this.user.dateOfBirth.year + '-' + this.user.dateOfBirth.month + '-' +this.user.dateOfBirth.day));
            this.date = this.date.replace(/\"|T.*/g, "").split("-");
            this.date = this.date[2] + "." + this.date[1] + "." + this.date[0];
        }
    },
});
Vue.component("user-thumbnail", {
    props: {
        user: {
            type: Object,
        },
        useDate: {
            type: Boolean,
            default: true,
        },
        useEmail: {
            type: Boolean,
            default: false
        }
    },
    data() {
        return {
            loggedInUser: null,
            date: null,
            link: '',
        }
    },
    template: `
    <div id="user-thumbnail" class="flex-container user-thumbnail-container">
        <router-link :to="link" class="profile-pic"><img :src="user.profilePic" alt="Profilna slika"></router-link>
        <router-link :to="link" class="fullname">{{user.name}} {{user.surname}}</router-link>
        <router-link v-if="useEmail" :to="link" class="email">{{user.email}}</router-link>
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
        getLink() {
            if (this.loggedInUser)
                return this.loggedInUser.username === this.user.username ? '/my-profile' : '/user/' + this.user.username
            return '/user/' + this.user.username

        }
    },
    mounted() {
        if (window.sessionStorage.getItem("user"))
            this.loggedInUser = JSON.parse(window.sessionStorage.getItem("user"))
        if (this.useDate) {
            this.date = new Date(this.user.dateOfBirth).toLocaleDateString();
        }
        this.link = this.getLink()
    },
});
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
    },
    computed: {
        link() {
            if (this.loggedInUser) {
                if (this.loggedInUser.username === this.user.username)
                    return '/my-profile'
                else
                    return '/user/' + this.user.username
            } else {
                return '/user/' + this.user.username
            }
        }
    },
    mounted() {
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/user", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    }
                }).then((response) => this.loggedInUser = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška"))
        }
        if (this.useDate) {
            this.date = new Date(this.user.dateOfBirth).toLocaleDateString();
        }
    },
});
Vue.component("message", {
    props: {
        message: Object
    },
    data() {
        return {
            user: null,
            profilePic: null,
        }
    },
    template: ` 
    <div id="message">
        <router-link :to="/user/+message.from" class="profile-pic"><img :src="profilePic" alt="Profilna slika"></router-link>
        <div class="message-text" :class="[message.from === user.username ? 'message-primary' : 'message-secondary']">{{message.message}}</div>
    </div>	 
`,
    methods: {},
    mounted() {
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/user", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    }
                }).then((response) => this.user = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška"))

            axios.get("/user/" + message.from + "/profile-pic", { // TODO: Add this request to backend
                    headers: {
                        Authorization: 'Bearer ' + window.sessionStorage.getItem("jwt"),
                    },
                }).then((response) => this.profilePic = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška."));
        } else {
            alert("Greška.")
        }
    },
});

// new Vue({}).$mount("#wrapper")
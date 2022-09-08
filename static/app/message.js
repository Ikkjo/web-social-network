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
    created() {
        this.profilePic = "../img/avatar1.jpg" // remove this line of code when TODO is done
        this.user = JSON.parse(window.sessionStorage.getItem("user"))
        return // remove this line of code when TODO is done
        if (window.sessionStorage.getItem("user")) {
            this.user = JSON.parse(window.sessionStorage.getItem("user"))
            axios.get("/user/" + message.from + "/profile-pic", { // TODO: Add this request to backend
                    headers: {
                        Authorization: 'Bearer ' + user.jwt,
                    },
                }).then((response) => this.profilePic = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška."));
        } else {
            alert("Greška.")
        }
    },
});

// new Vue({}).$mount("#wrapper")
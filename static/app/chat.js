Vue.component("chat", {
    data() {
        return {
            user: null,
            users: [],
            toUser: null,
            messages: [],
            newMessage: "",
        }
    },
    template: ` 
    <div id="chat">
        <nav-bar></nav-bar>
        <div class="container">
            <div class="users">
                <div v-for="(u, i) in users" :key="i" class="flex-container user-thumbnail-container" :class="{'active-user' : u.username === toUser}" @click="getMessages(u.username)">
                    <img class="profile-pic" :src="u.profilePic" alt="Profilna slika">
                    <span class="fullname">{{u.name}} {{u.surname}}</span>
                </div>
            </div>
            <div class="chat-area">
                <div class="chat-box">
                    <message v-for="(message, i) in messages" :key="i" :message="message" class="message" :class="[message.from === user.username ? 'message-left' : 'message-right']""/>
                </div>
                <div class="text-box">
                    <textarea
                        v-model="newMessage"
                        @keyup="textAreaAdjust"
                        @keyup.enter="sendMessage"   
                        type="text"/>
                    <button :disabled="!newMessage.replace(/^\s+|\s+$/g, '') || !newMessage.replace(/\\n/g,'')" @click="sendMessage" class="btn"><i class="fas fa-paper-plane"></i> Pošalji</button></a>
                </div>
            </div>
        </div>
    </div>	 
`,
    methods: {
        textAreaAdjust(event) {
            let area = event.target;
            area.style.height = "1px";
            area.style.height = (25 + area.scrollHeight) + "px";
        },
        sendMessage(event) {
            if (event.shiftKey)
                return
            let text = this.newMessage.replace(/^\s+|\s+$/g, '')
            text = text.replace(/\\n/g, '')
            if (text) {
                console.log({ from: this.user.username, to: this.toUser, message: this.newMessage })
                axios.post("/add-message/", { from: this.user.username, to: this.toUser, message: this.newMessage }, {
                        headers: {
                            Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                        }
                    }).then((response) => {
                        console.log("POSLATO")
                        this.messages.push(JSON.parse(JSON.stringify(response.data)))
                    })
                    .catch(() => alert("Greška"))

                this.newMessage = ""
                let area = event.target;
                area.style.height = "69px";
            }
        },
        scrollToEnd() {
            let el = document.querySelector(".chat-box")
            el.scrollTop = el.lastElementChild.offsetTop;
        },
        getMessages(username) {
            axios.get("/get-messages/?sender=" + username + "&receiver=" + this.user.username, {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    },
                }).then((response) => {
                    this.messages = JSON.parse(JSON.stringify(response.data))
                    this.toUser = username;
                })
                .catch(() => alert("Greška."))
        }
    },
    updated() {
        this.$nextTick(() => this.scrollToEnd());
    },
    mounted() {
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/user", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    }
                }).then((response) => this.user = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška"))

            // Get all users that sent messages to the logged in user
            axios.get("/get-chats", { // TODO: Add this request to backend
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt,
                    },
                }).then((response) => this.users.push.apply(this.users, JSON.parse(JSON.stringify(response.data))))
                .catch(() => alert("Greška."));


            // Get messages from the first user in users list
            let username = this.$route.params.username
            if (username) {
                axios.get("/user/" + username, { // TODO: Add this request to backend
                        headers: {
                            Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt,
                        },
                    }).then((response) => {
                        this.users.push(response.data)
                        this.toUser = username;
                    })
                    .catch(() => alert("Greška."));


                axios.get("/get-messages/?sender=" + username + "&receiver=" + this.user.username, {
                        headers: {
                            Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                        },
                    }).then((response) => {
                        this.messages = JSON.parse(JSON.stringify(response.data))
                        this.toUser = username
                    })
                    .catch(() => alert("Greška."))
            } else {
                axios.get("/get-messages/?sender=" + this.users[0].username + "&receiver=" + this.user.username, {
                        headers: {
                            Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                        },
                    }).then((response) => {
                        this.messages = JSON.parse(JSON.stringify(response.data))
                        this.toUser = this.users[0].username
                    })
                    .catch(() => alert("Greška."))
            }
        } else {
            this.$router.push("/")
        }
    },
});

// new Vue({}).$mount("#wrapper")
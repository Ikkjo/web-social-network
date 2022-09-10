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
        getMessages(username) {
            this.toUser = username
            return
            // TODO: Add this request to backend
            axios.get("/chat/messages/" + username, {
                    headers: {
                        Authorization: 'Bearer' + this.user.jwt
                    },
                }).then((response) => {
                    this.messages = JSON.parse(JSON.stringify(response.data))
                    this.toUser = username
                })
                .catch(() => alert("Greška."))
        },
        sendMessage(event) {
            if (event.shiftKey)
                return
            let text = this.newMessage.replace(/^\s+|\s+$/g, '')
            text = text.replace(/\\n/g, '')
            if (text) {
                let message = {
                        from: this.user.username,
                        to: this.toUser,
                        message: this.newMessage
                    }
                    // TODO: Send the message
                this.messages.push(message)
                this.newMessage = ""
                let area = event.target;
                area.style.height = "69px";
            }
        },
        scrollToEnd() {
            let el = document.querySelector(".chat-box")
            el.scrollTop = el.lastElementChild.offsetTop;
        }
    },
    updated() {
        this.$nextTick(() => this.scrollToEnd());
    },
    mounted() {
        axios.get("/user", {
                headers: {
                    Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                }
            }).then((response) => this.user = JSON.parse(JSON.stringify(response.data)))
            .catch(() => alert("Greška"))
        this.users = [{
                name: "Aco",
                surname: "Vucic",
                username: "avucic",
                profilePic: "../img/avatar1.jpg"
            },
            {
                name: "Aco",
                surname: "Vucic",
                username: "avucic2",
                profilePic: "../img/avatar1.jpg"
            },
            {
                name: "Aco",
                surname: "Vucic",
                username: "avucic3",
                profilePic: "../img/avatar1.jpg"
            },
            {
                name: "Aco",
                surname: "Vucic",
                username: "avucic4",
                profilePic: "../img/avatar1.jpg"
            }
        ]
        this.messages = [{
                from: "avucic",
                to: "test1",
                message: "Peri veš noću brate, štedi struju"
            },
            {
                from: "avucic",
                to: "test1",
                message: "Brate nije u redu, mora se štedi"
            },
            {
                from: "test1",
                to: "avucic",
                message: "Vučko brate mojne smaraš"
            },
            {
                from: "test1",
                to: "avucic",
                message: "Perem veš kad oću!"
            }
        ]
        this.toUser = "avucic"
        return
        // TODO: Remove above code
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/user", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    }
                }).then((response) => this.user = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška"))

            // Get all users that sent messages to the logged in user
            axios.get("/chat/" + this.user.username + "/users", { // TODO: Add this request to backend
                    headers: {
                        Authorization: 'Bearer ' + this.user.jwt,
                    },
                }).then((response) => this.users = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška."));

            // Get messages from the first user in users list
            let username = this.$route.params.username
            if (username) {
                this.getMessages(username);
            } else {
                this.getMessages(this.users[0].username)
            }
        } else {
            this.$router.push("/")
        }
    },
});

// new Vue({}).$mount("#wrapper")
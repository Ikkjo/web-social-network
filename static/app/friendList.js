Vue.component("friend-list", {
    data() {
        return {
            friends: [],
            user: null,
        }
    },
    template: ` 
    <div id="friend-list">
    <nav-bar></nav-bar>
    <div class="container">
        <div class="friends">
            <friend-card v-for="(friend, i) in friends" :key="i" :friend="friends[i]" @removeFriend="removeFriend"/>
        </div>
    </div>
    </div>	 
`,
    methods: {
        removeFriend(username) {
            axios.delete("/remove-friend/" + username, {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt,
                    },
                }).then((response) => {
                    for (let i = 0; i < this.friends.length; i++)
                        if (this.friends[i].username === username)
                            this.friends.splice(i, 1);
                })
                .catch(() => alert("Greška."));
        },
    },
    mounted() {
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/user", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    }
                }).then((response) => this.user = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška"))

            axios.get("/my-friends", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt,
                    },
                }).then((response) => this.friends = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška."));
        } else {
            alert("Greška.")
        }
    },
});

// new Vue({}).$mount("#wrapper")
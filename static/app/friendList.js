Vue.component("friend-list", {
    data() {
        return {
            friends: []
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
            if (window.sessionStorage.getItem("user")) {
                let user = JSON.parse(window.sessionStorage.getItem("user"))
                axios.delete("/remove-friend/" + username, {
                        headers: {
                            Authorization: 'Bearer ' + user.jwt,
                        },
                    }).then((response) => {
                        for (let i = 0; i < this.friends.length; i++)
                            if (this.friends[i].username === username)
                                this.friends.splice(i, 1);
                    })
                    .catch(() => alert("Greška."));
            } else {
                alert("Greška.")
            }
        },
        getFriends() {
            if (window.sessionStorage.getItem("user")) {
                let user = JSON.parse(window.sessionStorage.getItem("user"))
                axios.get("/my-friends", {
                        headers: {
                            Authorization: 'Bearer ' + user.jwt,
                        },
                    }).then((response) => this.friends = JSON.parse(JSON.stringify(response.data)))
                    .catch(() => alert("Greška."));
            } else {
                alert("Greška.")
            }
        }
    },
    mounted() {
        this.getFriends()
    },
});

// new Vue({}).$mount("#wrapper")
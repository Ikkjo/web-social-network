Vue.component("mutual-friends-list", {
    data() {
        return {
            friends: []
        }
    },
    template: ` 
    <div id="mutual-friends-list">
    <nav-bar></nav-bar>
    <div class="container">
        <div class="friends">
            <friend-card v-for="(friend, i) in friends" :key="i" :friend="friends[i]" @removeFriend="removeFriend"/>
        </div>
    </div>
    </div>	 
`,
    methods: {
        removeFriend(id) {
            console.log("id: " + id)
            for (let i = 0; i < this.friends.length; i++)
                if (this.friends[i].id === id)
                    this.friends.splice(i, 1);
        },
    },
    mounted() {
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/mutual-friends/", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    }
                }).then((response) => this.friends = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška"))
        }
    },
});

// new Vue({}).$mount("#wrapper")
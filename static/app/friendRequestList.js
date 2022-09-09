Vue.component("friend-request-list", {
    data() {
        return {
            friendRequests: []
        }
    },
    template: ` 
    <div id="friend-request-list">
    <nav-bar></nav-bar>
    <div class="container">
        <div class="friend-requests">
            <friend-request-card v-for="(friendRequest, i) in friendRequests" :key="i" :friendRequest="friendRequests[i]" @removeRequest="removeRequest"/>
        </div>
    </div>
    </div>	 
`,
    methods: {
        removeRequest(from) {
            for (let i = 0; i < this.friendRequests.length; i++)
                if (this.friendRequests[i].from === from)
                    this.friendRequests.splice(i, 1);
        },
        getFriendRequests() {
            // TODO: Add get friend requests
            if (window.sessionStorage.getItem("user")) {
                let user = JSON.parse(window.sessionStorage.getItem("user"))
                axios.get("/friend-requests", {
                        headers: {
                            Authorization: 'Bearer ' + user.jwt,
                        },
                    }).then((response) => this.friendRequests = JSON.parse(JSON.stringify(response.data)))
                    .catch(() => alert("Greška."));
            } else {
                alert("Greška.")
            }
        }
    },
    mounted() {
        this.getFriendRequests();
    },
});

// new Vue({}).$mount("#wrapper")
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

        }
    },
    mounted() {
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/friend-requests", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt,
                    },
                }).then((response) => this.friendRequests = JSON.parse(JSON.stringify(response.data)))
                .catch(() => alert("Greška."));
        } else {
            alert("Greška.")
        }
    },
});

// new Vue({}).$mount("#wrapper")
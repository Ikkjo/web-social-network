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
        removeRequest(id) {
            console.log("id: " + id)
            for (let i = 0; i < this.friendRequests.length; i++)
                if (this.friendRequests[i].id === id)
                    this.friendRequests.splice(i, 1);
        },
        getFriendRequests() {
            // TODO: Add get friend requests
            return [{
                    user: {
                        name: 'Test',
                        surname: 'Testic',
                        profilePic: "../img/female_avatar.svg",
                        username: "nekoime"
                    },
                    id: 0,
                },
                {
                    user: {
                        name: 'Test',
                        surname: 'Testic',
                        profilePic: "../img/female_avatar.svg",
                        username: "nekoime"
                    },
                    id: 1,
                }
            ]

        }
    },
    mounted() {
        this.friendRequests = this.getFriendRequests();
    },
});

// new Vue({}).$mount("#wrapper")
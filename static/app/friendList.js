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
        removeFriend(id) {
            console.log("id: " + id)
            for (let i = 0; i < this.friends.length; i++)
                if (this.friends[i].id === id)
                    this.friends.splice(i, 1);
        },
        getFriends() {
            // TODO: Add get friends
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
        this.friends = this.getFriends();
    },
});

// new Vue({}).$mount("#wrapper")
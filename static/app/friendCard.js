Vue.component("friend-card", {
    data() {
        return {
            user: {
                name: 'Test',
                surname: 'Testic',
                profilePic: "../img/female_avatar.svg",
                username: "nekoime"
            },
        }
    },
    template: ` 
    <div id="friend-card">
            <user-thumbnail
                :user="user"
                :useDate="false" 
                class="user-thumbnail"/>
            <i class="fas fa-user-minus"></i>
    </div>	 
`,
    methods: {},
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
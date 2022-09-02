Vue.component("friend-request-card", {
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
    <div id="friend-request-card">
            <user-thumbnail
                :user="user"
                :useDate="false" 
                class="user-thumbnail"/>
            <i class="fas fa-user-check accept"></i>
            <i class="fas fa-user-alt-slash decline"></i>
    </div>	 
`,
    methods: {},
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
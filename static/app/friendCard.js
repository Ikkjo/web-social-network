Vue.component("friend-card", {
    props: {
        friend: Object
    },
    template: ` 
    <div id="friend-card">
            <user-thumbnail
                :user="friend.user"
                :useDate="false" 
                class="user-thumbnail"/>
            <i @click="removeFriend" class="fas fa-user-minus"></i>
    </div>	 
`,
    methods: {
        removeFriend() {
            this.$emit("removeFriend", this.friend.username)
        }
    },
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
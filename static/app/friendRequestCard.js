Vue.component("friend-request-card", {
    props: {
        friendRequest: Object
    },
    data() {
        return {

        }
    },
    template: ` 
    <div id="friend-request-card">
            <user-thumbnail
                :user="friendRequest.user"
                :useDate="false" 
                class="user-thumbnail"/>
            <i @click="acceptRequest" class="fas fa-user-check accept"></i>
            <i @click="declineRequest" class="fas fa-user-alt-slash decline"></i>
    </div>	 
`,
    methods: {
        acceptRequest() {
            // TODO: add backend request (acceptRequest)
            this.$emit("removeRequest", this.friendRequest.id)
        },
        declineRequest() {
            // TODO: add backend request (declineRequest)
            this.$emit("removeRequest", this.friendRequest.id)
        },
    },
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
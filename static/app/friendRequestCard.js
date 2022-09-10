Vue.component("friend-request-card", {
    props: {
        friendRequest: Object
    },
    data() {
        return {}
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
            if (window.sessionStorage.getItem("jwt")) {
                axios.put("/accept-request/" + this.friendRequest.from, {
                        headers: {
                            Authorization: 'Bearer ' + window.sessionStorage.getItem("jwt"),
                        },
                    }).then((response) => {})
                    .catch(() => alert("Greška."));
            } else {
                alert("Greška.")
            }
            this.$emit("removeRequest", this.friendRequest.from)
        },
        declineRequest() {
            if (window.sessionStorage.getItem("jwt")) {
                let jwt = 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                axios.delete("/decline-request/" + this.friendRequest.from, {
                        headers: {
                            Authorization: 'Bearer ' + jwt,
                        },
                    }).then((response) => {})
                    .catch(() => alert("Greška."));
            } else {
                alert("Greška.")
            }
            this.$emit("removeRequest", this.friendRequest.from)
        },
    },
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
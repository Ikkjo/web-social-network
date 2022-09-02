Vue.component("friend-request-list", {
    data() {
        return {}
    },
    template: ` 
    <div id="friend-request-list">
    <nav-bar></nav-bar>
    <div class="container">
        <div class="friend-requests">
            <friend-request-card></friend-request-card>
            <friend-request-card></friend-request-card>
            <friend-request-card></friend-request-card>
            <friend-request-card></friend-request-card>
        </div>
    </div>
    </div>	 
`,
    methods: {},
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
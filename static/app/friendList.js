Vue.component("friend-list", {
    data() {
        return {}
    },
    template: ` 
    <div id="friend-list">
    <nav-bar></nav-bar>
    <div class="container">
        <div class="friends">
            <friend-card></friend-card>
            <friend-card></friend-card>
            <friend-card></friend-card>
            <friend-card></friend-card>
        </div>
    </div>
    </div>	 
`,
    methods: {},
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
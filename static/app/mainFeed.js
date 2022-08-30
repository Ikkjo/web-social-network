Vue.component("main-feed", {
    data() {
        return {}
    },
    template: ` 
    <div id="main-feed">
    <nav-bar></nav-bar>
    <div class="container">
        <add-post></add-post>
        <div class="posts">
            <post></post>
            <post></post>
            <post></post>
            <post></post>
        </div>
    </div>
    </div>	 
`,
    methods: {},
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
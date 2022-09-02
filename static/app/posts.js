Vue.component("posts", {
    data() {
        return {}
    },
    template: ` 
    <div id="posts">
    <nav-bar></nav-bar>
    <div class="container">
        <add-post defaultType="text"></add-post>
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
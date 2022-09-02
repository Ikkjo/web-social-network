Vue.component("photos", {
    data() {
        return {}
    },
    template: ` 
    <div id="photos">
    <nav-bar></nav-bar>
    <div class="container">
        <add-post defaultType="photo"></add-post>
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
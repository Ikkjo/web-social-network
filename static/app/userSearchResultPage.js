Vue.component("user-search-result-page", {
    data() {
        return {
            users: null,
        }
    },
    template: `
    <div class="container">
        <user-search-result v-for="u in users" :user="u" :key="u.username"></user-search-result>            
    </div>
    `,
    methods: {},
    mounted() {
        let params = this.$route.params;
        axios.get("/user-search/", {
            params: params
        }).then(response => this.users = response.data)
        .catch(error => alert("Pretraga neuspješna."));
    },
});
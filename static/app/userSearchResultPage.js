Vue.component("user-search-result-page", {
    data() {
        return {
            users: null,
        }
    },
    template: `
    <div class="container">
        <user-search-result v-for="user in users"></user-search-result>            
    </div>
    `,
    methods: {},
    mounted() {
       this.users = router.params.users
    },
});
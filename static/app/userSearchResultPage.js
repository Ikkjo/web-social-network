Vue.component("user-search-result-page", {
    data() {
        return {
            users: null,
            params: null,
        }
    },
    template: `
    <div class="container">
        <nav-bar></nav-bar>
        <div class="user-search-result-page-container">
            <div class="user-search-inner-container">
                <div class="sort-continer">
                    <label for="sort">Kriterijum sortiranja:</label>
                    <select name="sort" id="sort">
                        <option v-if="this.params.name" value="name">Ime</option>
                        <option v-if="this.params.surname" value="surname">Prezime</option>
                        <option v-if="this.params.date" value="date">Datum rođenja</option>
                    </select>
                </div>
                <user-search-result v-for="u in users" :user="u" :key="u.username"></user-search-result>            
            </div>
        </div>
    </div>
    `,
    methods: {},
    mounted() {
        this.params = this.$route.params;
        axios.get("/user-search/", {
            params: this.params
        }).then(response => this.users = response.data)
        .catch(error => alert("Pretraga neuspješna."));
    },
});
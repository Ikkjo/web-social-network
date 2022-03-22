Vue.component("user-search-result-page", {
    data() {
        return {
            users: null,
        }
    },
    template: `
    <div class="container">
        <nav-bar></nav-bar>
        <div class="user-search-result-page-container">
            <div class="user-search-inner-container">
                <div class="sort-continer">
                    <label for="sort">Kriterijum sortiranja:</label>
                    <select name="sort" id="sort" @change="sort($event)">
                        <option value="name">Ime</option>
                        <option value="surname">Prezime</option>
                        <option value="dateOfBirth">Datum rođenja</option>
                    </select>
                </div>
                <user-search-result v-for="u in users" :user="u" :key="u.username"></user-search-result>            
            </div>
        </div>
    </div>
    `,
    methods: {
        sort(event) {
            let sortBy = event.target.value;
            this.users.sort((a, b) => (a[sortBy] > b[sortBy]) ? 1 : (a[sortBy] < b[sortBy] ? -1 : 0));
        },
    },
    mounted() {
        let params = this.$route.params;
        axios.get("/user-search/", {
            params: params
        }).then(response => this.users = response.data.sort((a, b) => (a.name > b.name) ? 1 : (a.name < b.name ? -1 : 0)))
        .catch(error => alert("Pretraga neuspješna."));
    },
});
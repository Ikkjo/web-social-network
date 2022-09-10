Vue.component("user-search-page", {
    data() {
        return {};
    },
    template: `
    <div class="container">
        <nav-bar></nav-bar>
        <user-search :key="this.$route.query"></user-search>
    </div>
    `,
    methods: {},
    mounted() {},
});

Vue.component("user-search", {
    data() {
        return {
            users: null,
        }
    },
    template: `
    <div class="user-search-result-container">
        <div v-if="users" class="user-search-inner-container">
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
    `,
    methods: {
        sort(event) {
            let sortBy = event.target.value;
            switch (sortBy) {
                case 'name':
                    this.users.sort((a, b) => (a.name > b.name) ? 1 : (a.name < b.name) ? -1 : 0);
                case 'surname':
                    this.users.sort((a, b) => (a.surname > b.surname) ? 1 : (a.surname < b.surname) ? -1 : 0);
                case 'dateOfBirth':
                    this.users.sort((a, b) => new Date(a.dateOfBirth.year + '-' + a.dateOfBirth.month + '-' + a.dateOfBirth.day) - new Date(b.dateOfBirth.year + '-' + b.dateOfBirth.month + '-' + b.dateOfBirth.day));
            }
        },
    },
    mounted() {
        let params = this.$route.query;
        axios.get("/user-search/", {
                params: params
            }).then(response => this.users = response.data.sort((a, b) => (a.name > b.name) ? 1 : (a.name < b.name ? -1 : 0)))
            .catch(error => alert("Pretraga neuspješna."));
    },
});
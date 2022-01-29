Vue.component("nav-bar", {
    data() {
        return {}
    },
    template: `
    <div class="container">
        <div class="nav-div">
            <img class="logo" src="" alt="logo">
            <nav>
                <ul class="nav-links">
                    <li><router-link to="">Početna</router-link></li>
                    <li><router-link to="">Profil</router-link></li>
                    <li><user-search-dropdown></user-search-dropdown></li>
                </ul>
            </nav>
            <a class="cta" href="#"><button class="btn">Izloguj se</button></a>
        </div>
    </div>
    `,
    methods: { isFocused(field) { return this.infocus[field] }, inFocus(field) { this.infocus[field] = true }, outFocus(field) { this.infocus[field] = false } },
    mounted() {},
    validations: {
        form: {
            username: { required: validators.required, },
            password: { required: validators.required, },
        }
    }
});
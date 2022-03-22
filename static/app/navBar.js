Vue.component("nav-bar", {
    data() {
        return {
            user: {
                guest: false,
            }
        }
    },
    template: `
    <div class="nav-container">
        <div class="nav-div">
            <img class="logo" src="./img/logo.svg" alt="logo">
            <nav>
                <ul class="nav-links">
                    <li><i class="fas fa-home"></i> <router-link to="/feed">Početna</router-link></li>
                    <li v-if="!user.guest"><i class="fas fa-user"></i> <router-link to="/user/profile">Profil</router-link></li>
                    <li><user-search-dropdown></user-search-dropdown></li>
                </ul>
            </nav>
            <button @click="signOut" class="btn"><i class="fas fa-sign-out-alt"></i> Odjavi se</button></a>
        </div>
    </div>
    `,
    methods: {
        isFocused(field) {
            return this.infocus[field]
        },
        inFocus(field) {
            this.infocus[field] = true
        },
        outFocus(field) {
            this.infocus[field] = false
        },
        signOut() {
            window.sessionStorage.removeItem("user");
            router.push("/login")
        },
     },
    mounted() {},
    validations: {
        form: {
            username: { required: validators.required, },
            password: { required: validators.required, },
        }
    }
});
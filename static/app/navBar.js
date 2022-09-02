Vue.component("nav-bar", {
    data() {
        return {
            user: true
        }
    },
    template: `
    <header id="nav-header">
            <img class="logo" src="./img/logo.svg" alt="logo">
            <nav>
                <ul class="nav-links">
                    <li><i class="fas fa-home"></i> <router-link to="/">Početna</router-link></li>
                    <li v-if="user"><i class="fas fa-user"></i> <router-link to="/my-profile">Profil</router-link></li>
                    <li><user-search-dropdown></user-search-dropdown></li>
                </ul>
            </nav>
            <button v-if="user" @click="signOut" class="btn nav-btn"><i class="fas fa-sign-out-alt"></i> Odjavi se</button></a>
            <button v-if="!user" @click="signIn" class="btn nav-btn"><i class="fas fa-sign-in-alt"></i> Uloguj se</button></a>
    </header>
    `,
    methods: {
        signOut() {
            window.sessionStorage.removeItem("user");
            router.push("/login")
        },
        signIn() {
            router.push("/login")
        }
    },
    mounted() {
        if (window.sessionStorage.getItem("user"))
            this.user = JSON.parse(window.sessionStorage.getItem("user"))

    },
});
Vue.component("nav-bar", {
    data() {
        return {
            user: null
        }
    },
    template: `
    <div class="nav-container">
        <div class="nav-div">
            <img class="logo" src="./img/logo.svg" alt="logo">
            <nav>
                <ul class="nav-links">
                    <li><i class="fas fa-home"></i> <router-link to="/feed">Početna</router-link></li>
                    <li v-if="user"><i class="fas fa-user"></i> <router-link :to="/user/+user.username">Profil</router-link></li>
                    <li><user-search-dropdown></user-search-dropdown></li>
                </ul>
            </nav>
            <button @click="signOut" class="btn"><i class="fas fa-sign-out-alt"></i> Odjavi se</button></a>
        </div>
    </div>
    `,
    methods: {
        signOut() {
            window.sessionStorage.removeItem("user");
            router.push("/login")
        },
     },
    mounted() {
        if (window.sessionStorage.getItem("user"))
            this.user = JSON.parse(window.sessionStorage.getItem("user"))

    },
});
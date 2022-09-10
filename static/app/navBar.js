Vue.component("nav-bar", {
    data() {
        return {
            user: null
        }
    },
    template: `
    <header id="nav-header">
            <img class="logo" src="./img/logo.svg" alt="logo">
            <nav>
                <ul class="nav-links">
                    <li><i class="fas fa-home"></i> <router-link to="/">Početna</router-link></li>
                    <li v-if="user && user.role.toLowerCase() === 'regular'"><i class="fas fa-user"></i> <router-link to="/my-profile">Profil</router-link></li>
                    <li v-if="user && user.role.toLowerCase() === 'regular'"><i class="fas fa-users"></i><router-link to="/friend-request-list"> Zahtevi za prijateljstvo</router-link></li>
                    <li><user-search-dropdown :useEmail="user && user.role.toLowerCase()==='admin'"/></li>
                </ul>
            </nav>
            <button v-if="user" @click="signOut" class="btn nav-btn"><i class="fas fa-sign-out-alt"></i> Odjavi se</button></a>
            <button v-if="!user" @click="signIn" class="btn nav-btn"><i class="fas fa-sign-in-alt"></i> Uloguj se</button></a>
    </header>
    `,
    methods: {
        signOut() {
            window.sessionStorage.removeItem("jwt");
            router.push("/login")
        },
        signIn() {
            router.push("/login")
        }
    },
    mounted() {
        if (window.sessionStorage.getItem("jwt"))
            axios.get("/user", {
                headers: {
                    Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                }
            }).then((response) => this.user = JSON.parse(JSON.stringify(response.data)))
            .catch(() => alert("Greška"))

    },
});
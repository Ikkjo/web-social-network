Vue.component("my-profile", {
    data() {
        return {
            user: null,
            isFriend: false,
        }
    },
    template: `
    <div class="container">
        <nav-bar></nav-bar>
        <div class="container flex-container">
            <div class="inner-container">
                <div class="my-profile-container">
                    <div class="profile ">
                        <img src="./img/profile_pic.svg" alt=" " class="profile-thumbnail ">
                        <h2 class="user-fullname">{{ user.name}} {{user.surname }}</h2>
                        <div class="dob">{{ user.dateOfBirth }}</div>
                    </div>
                    <div class="user-links" v-bind:class="{'user-links-50' : user.isPublic && !isFriend}">
                        <div class="links-top">
                                <div class="link-group">
                                    <i class="fas fa-book-open"></i>
                                    <router-link to="/my-posts">Objave</router-link>
                                </div>
                                <div class="link-group">
                                <i class="fas fa-images"></i>
                                <router-link to="/my-photos">Fotografije</router-link>
                                </div>
                                <div class="link-group">
                                <i class="fas fa-user-friends"></i>
                                <router-link to="/friend-list">Prijatelji</router-link>
                                </div>
                                <div class="link-group">
                                    <i class="fas fa-users"></i>
                                    <router-link to="/friend-request-list">Zahtevi</router-link>
                                </div>
                                <div class="link-group">
                                    <i class="fas fa-edit"></i>
                                    <router-link to="/edit-profile">Uredi profil</router-link>
                                </div>
                        </div>
                        <div class="links-bottom">
                            <button class="btn btn-message" @click="openMessages"><i class="fas fa-comment-dots"></i>Poruke</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="inner-container picture-container user-side-picture">
                <span><img src="./img/user_profile.svg " alt=" "></span>
            </div>
        </div>
    </div>
    `,
    methods: {
        openMessages() {
            this.$router.push("/chat/" + "");
        }
    },
    mounted() {
        if (window.sessionStorage.getItem("user")) {
            this.loggedInUser = JSON.parse(window.sessionStorage.getItem("user"))
            let username = JSON.parse(window.sessionStorage.getItem("user")).username;
            let token = JSON.parse(window.sessionStorage.getItem("user")).jwt
            axios.get("/are-friends/" + this.$route.params.username, {
                    headers: {
                        Authorization: 'Bearer ' + token,
                    },
                }).then((response) => this.isFriend = response.data)
                .catch(() => alert("Greška."));
        }
        axios.get("/user/" + this.$route.params.username).then((response) => {
                console.log(response.data)
                this.user = JSON.parse(JSON.stringify(response.data))
            })
            .catch(() => alert("Došlo je do greške."))
    },
});
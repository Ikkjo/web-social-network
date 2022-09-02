Vue.component("my-profile", {
    data() {
        return {
            user: {
                name: "Neko",
                surname: "Prezime",
                isPublic: true,
            },
            isFriend: true,
            isAdmin: false,
            loggedUser: true,
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
                                    <router-link to="/posts">Objave</router-link>
                                </div>
                                <div class="link-group">
                                <i class="fas fa-images"></i>
                                <router-link to="/photos">Fotografije</router-link>
                                </div>
                                <div class="link-group">
                                <i class="fas fa-user-friends"></i>
                                <router-link to="/mutual-friends">Prijatelji</router-link>
                                </div>
                        </div>
                        <div class="links-bottom">
                            <button class="btn btn-message"><i class="fas fa-comment-dots"></i>Poruke</button>
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
    methods: {},
    mounted() {},
});
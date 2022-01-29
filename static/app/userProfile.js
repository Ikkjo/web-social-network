Vue.component("user-profile", {
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
        <div class="inner-container">
            <div class="user-profile-container">
                <div class="profile ">
                    <img src="./img/profile_pic.svg " alt=" " class="profile-thumbnail ">
                    <h2 class="user-fullname">{{ user.name}} {{user.surname }}</h2>
                    <div class="dob">{{ user.dateOfBirth }}</div>
                </div>

                <div class="user-links" v-bind:class="{'user-links-50' : user.isPublic && !isFriend}">
                    <div class="links-top">
                        <div v-if="isFriend || user.isPublic" class="link-group">
                            <i class="fas fa-book-open"></i>
                            <router-link to="/posts">Objave</router-link>
                        </div>
                        <div v-if="isFriend || user.isPublic" class="link-group">
                            <i class="fas fa-images"></i>
                            <router-link to="/mutual-friends">Fotografije</router-link>
                        </div>
                        <div v-if="isFriend" class="link-group">
                            <i class="fas fa-user-friends"></i>
                            <router-link to="/mutual-friends">Zajednički prijatelji/ce</router-link>
                        </div>
                    </div>

                    <div class="links-bottom">
                        <!-- <div>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"><div><i class="fas fa-user-slash"></i></div></span>
                            </label>
                        </div>
                        <div> -->
                        <button v-if="isFriend || isAdmin" class="btn btn-message"><i class="fas fa-comment-dots"></i>Poruka</button>
                        <button v-if="loggedUser" class="btn transparent" v-bind:class="{unfriend: isFriend}"><i v-bind:class="[isFriend ? 'fas fa-user-minus' : 'fas fa-user-plus']"></i>{{isFriend ? 'Izbriši iz prijatelja' : 'Pošalji zahtev'}}</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="inner-container picture-container user-side-picture">
            <span><img src="./img/user_profile.svg " alt=" "></span>
        </div>
    </div>
    `,
    methods: {},
    mounted() {},
});
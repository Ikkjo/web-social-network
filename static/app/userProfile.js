Vue.component("user-profile", {
    data() {
        return {
            user: {
                name: "Neko",
                surname: "Prezime"
            },
            isFriend: true,
        }
    },
    template: `
    <div class="container">
        <div class="inner-container">
            <div class=" user-profile-container ">
                <div class="profile ">
                    <img src="./img/profile_pic.svg " alt=" " class="profile-thumbnail ">
                    <h2 class="user-fullname">{{ user.name}} {{user.surname }}</h2>
                    <div class="dob">{{ user.dateOfBirth }}</div>
                </div>

                <div class="user-links ">
                    <div class="links-top">
                        <div class="link-group">
                            <i class="fas fa-book-open"></i>
                            <router-link to="/posts">Objave</router-link>
                        </div>
                        <div class="link-group">
                            <i class="fas fa-images"></i>
                            <router-link to="/mutual-friends">Fotografije</router-link>
                        </div>
                        <div class="link-group">
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
                        <button class="btn btn-message"><i class="fas fa-comment-dots"></i>Poruka</button>
                        <button class="btn transparent" v-bind:class="{unfriend: isFriend}"><i class="fas fa-user-plus"></i>{{isFriend ? 'Izbriši iz prijatelja' : 'Pošalji zahtev'}}</button>
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
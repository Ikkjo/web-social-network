Vue.component("user-profile", { data() { return { } }, template: `
<div class="container">
    <div class="inner-container">
        <div class=" user-profile-container ">
            <div class="profile ">
                <img src="./img/profilePic.svg " alt=" " class="profile-thumbnail ">
                <h2 class="user-fullname">Imenko Prezimić</h2>
            </div>

            <div class="user-links ">
                <div class="links-left ">
                    <div class="link-group">
                        <i class="fas fa-book-open"></i>
                        <a href=" ">Objave</a>
                    </div>
                    <div class="link-group">
                        <i class="fas fa-images"></i>
                        <a href=" ">Fotografije</a>
                    </div>
                    <div class="link-group">
                        <i class="fas fa-user-friends"></i>
                        <a href=" ">Zajednički prijatelji/ce</a>
                    </div>
                </div>
                <div class="links-right ">
                    <div class="link-group">
                        <i class="fas fa-user-slash"></i>
                        <a href=" ">Prijatelji</a>
                    </div>
                    <button class="btn"><i class="fas fa-comment-dots"></i>Poruka</button>
                </div>
            </div>
        </div>
    </div>
    <div class="inner-container picture-container user-side-picture">
        <span><img src="./img/user_profile.svg " alt=" "></span>
    </div>
</div>
`, methods: { }, mounted() {}, });
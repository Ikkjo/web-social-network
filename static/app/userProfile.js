Vue.component("user-profile", { data() { return { } }, template: `
<div class="container">
    <div class="inner-container">
        <div class=" user-profile-container ">
            <div class="profile ">
                <img src="./img/profile_pic.svg " alt=" " class="profile-thumbnail ">
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
                    <!-- <div>
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"><div><i class="fas fa-user-slash"></i></div></span>
                        </label>
                    </div>
                    <div> -->
                    <button class="btn btn-message"><i class="fas fa-comment-dots"></i>Poruka</button>
                    <button class="btn transparent btn-message"><i class="fas fa-user-plus"></i>Pošalji zahtev</button>
                </div>
            </div>
        </div>
    </div>
    <div class="inner-container picture-container user-side-picture">
        <span><img src="./img/user_profile.svg " alt=" "></span>
    </div>
</div>
`, methods: { }, mounted() {}, });
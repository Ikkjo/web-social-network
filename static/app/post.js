Vue.component("post", {
    data() {
        return {
            post: {
                user: {
                    name: 'Test',
                    surname: 'Testic',
                    profilePic: "../img/female_avatar.svg",
                    username: "nekoime"
                },
                type: 'photo',
                photo: "../img/avatar1.jpg",
                text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?'
            },
            user: {
                username: "nekoime"
            }
        }
    },
    template: ` 
    <div id="post">
        <div class="post-container">
            <i v-if="post.user.username === user.username" class="fas fa-trash-alt delete-post"></i>
            <img v-if="post.type==='photo'" class="image-div picture-container" :src="post.photo" alt="" srcset="">
            <div class="post-content">
                <user-thumbnail
                    :user="post.user"
                    :useDate="false" 
                    class="user-thumbnail"/>
                <div class="text-div">{{post.text}}</div>
                <img v-if="post.type==='text' && post.photo" class="image-div picture-container" :src="post.photo" alt="" srcset="">
                <div class="comments-div">
                    <textarea
                    @keyup="textAreaAdjust"   
                    type="text"
                    placeholder="Komentariši" name="add-comment"/>
                    <comment/>
                    <comment/>
                    <comment/>
                </div>
            </div>
        </div>
    </div>	 
`,
    methods: {
        textAreaAdjust(event) {
            let area = event.target;
            area.style.height = "1px";
            area.style.height = (25 + area.scrollHeight) + "px";
        }
    },
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
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
                type: 'text',
                photo: "../img/avatar1.jpg",
                text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?'
            },
            detailedView: false,
            user: {
                username: "nekoime"
            }
        }
    },
    template: ` 
    <div id="post">
        <div class="post-container">
            <i v-if="!detailedView" @click="detailedView=!detailedView" class="fas fa-arrow-down post-toggle"></i>
            <i v-if="detailedView" @click="detailedView=!detailedView" class="fas fa-arrow-up post-toggle"></i>
            <i v-if="post.user.username === user.username && detailedView" class="fas fa-trash-alt delete-post"></i>
            
            <div v-if="!detailedView">
                <user-thumbnail
                        :user="post.user"
                        :useDate="false" 
                        class="user-thumbnail user-thumbnail-collapsed"/>
                <img v-if="post.type==='photo'" class="image-div picture-container" :src="post.photo" alt="" srcset="">
                <div v-if="post.type==='text'" class="text-div text-div-collapsed">{{post.text}}</div>
            </div>

            <img v-if="post.type==='photo' && detailedView" class="image-div picture-container" :src="post.photo" alt="" srcset="">
            <div v-if="detailedView" class="post-content">
                <user-thumbnail
                    :user="post.user"
                    :useDate="false" 
                    class="user-thumbnail"
                    :class="{'user-thumbnail-text': (detailedView && post.type==='text')}"/>
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
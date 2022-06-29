Vue.component("post", {
    data() {
        return {
            post: {
                user: {
                    name: 'Test',
                    surname: 'Testic',
                    profilePic: "../img/female_avatar.svg"
                },
            },
        }
    },
    template: ` 
    <div id="post">
        <div class="post-container">
            <div class="image-div picture-container"></div>
            <div class="post-content">
                <user-thumbnail
                    :user="post.user"
                    :useDate="false" 
                    class="user-thumbnail"/>
                <div class="text-div">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?</div>
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
            area.style.height = (25+area.scrollHeight)+"px";
        }
    },
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
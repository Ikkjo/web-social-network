Vue.component("add-post", {
    data() {
        return {
            post: {
                user: {
                    name: 'Test',
                    surname: 'Testic',
                    profilePic: "../img/female_avatar.svg"
                },
                type: 'photo',
                photo: "../img/avatar1.jpg",
                text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?'
            },
        }
    },
    template: ` 
    <div id="add-post">
        <user-thumbnail
            :user="post.user"
            :useDate="false" 
            class="user-thumbnail"/>
        <textarea
            @keyup="textAreaAdjust"   
            type="text"
            placeholder="O čemu razmišljaš?" name="add-comment"/>
        <div class="button-div">
            <button @click="addPhoto" class="btn"><i class="fas fa-image"></i></i> Dodaj sliku</button></a>
            <button @click="post" class="btn btn-right"><i class="fas fa-plus-circle"></i> Objavi</button></a>
        </div>
    </div>	 
`,
    methods: {
        textAreaAdjust(event) {
            let area = event.target;
            area.style.height = "1px";
            area.style.height = (25 + area.scrollHeight) + "px";
        },
        post() {

        },
    },
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
Vue.component("comment", {
    data() {
        return {
            comment: {
                user: {
                    name: 'Test',
                    surname: 'Testic',
                    profilePic: "../img/female_avatar.svg"
                },
                text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
            },
        }
    },
    template: ` 
    <div id="comment">
        <user-thumbnail
            :user="comment.user"
            :useDate="false" 
            class="user-thumbnail"/>
        <div class="text-div">{{comment.text}}</div>
    </div>	 
`,
    methods: {
    },
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
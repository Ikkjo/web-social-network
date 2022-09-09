Vue.component("comment", {
    props: {
        comment: Object
    },
    data() {
        return {
            user: null
        }
    },
    template: ` 
    <div id="comment">
        <user-thumbnail
            :user="comment.user"
            :useDate="false" 
            class="user-thumbnail"/>
        <div v-if="user && (user.username === comment.user.username || user.role.toLowerCase() === 'admin')" class="delete-comment-div">
            <i @click="deleteComment" class="fas fa-trash-alt delete-comment"></i>
        </div>
        <div class="text-div">{{comment.text}}</div>
    </div>	 
`,
    methods: {
        deleteComment() {
            console.log(this.comment.id)
                // add delete request (use comment id)
            this.$emit("deleteComment", this.comment.id)
        }
    },
    mounted() {
        if (window.sessionStorage.getItem("user")) {
            this.user = JSON.parse(window.sessionStorage.getItem("user"))
        }
    },
});

// new Vue({}).$mount("#wrapper")
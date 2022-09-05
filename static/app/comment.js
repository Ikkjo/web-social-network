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
        <div v-if="user && user.username === comment.user.username" class="delete-comment-div">
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
        // TODO: get user from localstorage
    },
});

// new Vue({}).$mount("#wrapper")
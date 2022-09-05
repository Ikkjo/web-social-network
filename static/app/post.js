Vue.use(vuelidate.default)
Vue.component("post", {
    props: {
        post: Object,
    },
    data() {
        return {
            detailedView: false,
            user: null,
            newComment: null,
            infocus: {
                newComment: true
            }
        }
    },
    template: ` 
    <div id="post">
        <div class="post-container">
            <i v-if="!detailedView" @click="detailedView=!detailedView" class="fas fa-arrow-down post-toggle"></i>
            <i v-if="detailedView" @click="detailedView=!detailedView" class="fas fa-arrow-up post-toggle"></i>
            <i @click="deletePost" v-if="user && post.user.username === user.username && detailedView" class="fas fa-trash-alt delete-post"></i>
            
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
                    v-model="newComment"
                    @focus="inFocus('newComment')"
                    @blur="outFocus('newComment')"
                    @keyup.enter="addComment"
                    @keyup="textAreaAdjust"   
                    type="text"
                    placeholder="Komentariši" name="add-comment"/>
                    <div v-show="!isFocused('newComment') && $v.newComment.$invalid" class="alert alert-danger">Tekst je obavezan.</div>
                    <comment v-for="(comment, i) in post.comments" :key="i" :comment="post.comments[i]" @deleteComment="deleteComment"/>
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
        },
        addComment() {
            if (!this.newComment.replace(/^\s+|\s+$/g, ''))
                return
            let comment = { user: this.user, text: this.newComment };
            this.post.comments.push(comment);
            this.newComment = null;
            // TODO: add post request
        },
        deletePost() {
            // TODO: add delete request
            this.$emit("deletePost", this.post.id)
        },
        deleteComment(id) {
            console.log("ovde " + id)
            for (let i = 0; i < this.post.comments.length; i++)
                if (this.post.comments[i].id === id)
                    this.post.comments.splice(i, 1);
        },
        isFocused(field) {
            return this.infocus[field]
        },
        inFocus(field) {
            this.infocus[field] = true
        },
        outFocus(field) {
            this.infocus[field] = false
        },
    },
    mounted() {
        // TODO: set user to logged in user (from local storage)
    },
    validations: {
        newComment: {
            required: validators.required,
            minLength: validators.minLength(1),
            maxLength: validators.maxLength(1000)
        }
    },
});

// new Vue({}).$mount("#wrapper")
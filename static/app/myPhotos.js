Vue.component("my-photos", {
    data() {
        return {
            posts: []
        }
    },
    template: ` 
    <div id="photos">
    <nav-bar></nav-bar>
    <div class="container">
        <add-post defaultType="photo" @addedPost="addedPost"></add-post>
        <div class="posts">
            <post v-for="(post, i) in posts" :key="i" :post="posts[i]" @deletePost="deletePost"/>
        </div>
    </div>
    </div>	 
`,
    methods: {
        deletePost(id) {
            console.log("id: " + id)
            for (let i = 0; i < this.posts.length; i++)
                if (this.posts[i].id === id)
                    this.posts.splice(i, 1);
        },
        getPosts() {
            if (window.sessionStorage.getItem("user")) {
                let user = JSON.parse(window.sessionStorage.getItem("user"))
                axios.get("/my-photos", {
                        headers: {
                            Authorization: 'Bearer ' + user.jwt,
                        },
                    }).then((response) => this.posts = JSON.parse(JSON.stringify(response.data)))
                    .catch(() => alert("Greška."));
            } else {
                alert("Greška.")
            }
        },
        addedPost(newPost) {
            this.posts.splice(0, 0, newPost);
        }
    },
    mounted() {
        this.posts = this.getPosts();
    },
});

// new Vue({}).$mount("#wrapper")

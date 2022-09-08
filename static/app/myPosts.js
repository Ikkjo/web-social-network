Vue.component("my-posts", {
    data() {
        return {}
    },
    template: ` 
    <div id="posts">
    <nav-bar></nav-bar>
    <div class="container">
        <add-post defaultType="text"></add-post>
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
                let user = window.sessionStorage.getItem("user")
                axios.get("/post/user/" + user.username, { // TODO: Change request path
                        headers: {
                            Authorization: 'Bearer ' + user.jwt,
                        },
                    }).then((response) => this.posts = JSON.parse(JSON.stringify(response.data)))
                    .catch(() => alert("Greška."));
            } else {
                alert("Greška.")
            }
        },
    },
    mounted() {
        this.posts = this.getPosts();
    },
});

// new Vue({}).$mount("#wrapper")
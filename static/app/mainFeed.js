Vue.component("main-feed", {
    data() {
        return {
            posts: [],
            user: null,
        }
    },
    template: ` 
    <div id="main-feed">
    <nav-bar></nav-bar>
    <div class="container">
        <add-post v-if="user && user.role.toLowerCase()==='regular'" defaultType="all" @addedPost="addedPost"></add-post>
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
        addedPost(newPost) {
            this.posts.splice(0, 0, newPost);
        }
    },
    mounted() {
        if (window.sessionStorage.getItem("user")) {
            this.user = JSON.parse(window.sessionStorage.getItem("user"))
        }
        axios.get("/post/main-feed/", {}).then((response) => this.posts = JSON.parse(JSON.stringify(response.data)))
            .catch(() => alert("Greška."));
    },
});

// new Vue({}).$mount("#wrapper")
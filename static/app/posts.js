Vue.component("posts", {
    data() {
        return {
            posts: []
        }
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
    },
    mounted() {
        let token = "";
        if (window.sessionStorage.getItem("user"))
            token = window.sessionStorage.getItem("user").jwt
        axios.get("/post/user/" + this.$route.params.username, { // TODO: Update the request
                headers: {
                    Authorization: 'Bearer ' + token,
                },
            }).then((response) => this.posts = JSON.parse(JSON.stringify(response.data)))
            .catch(() => alert("Greška."));
    },
});

// new Vue({}).$mount("#wrapper")
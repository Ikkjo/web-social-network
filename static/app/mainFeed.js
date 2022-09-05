Vue.component("main-feed", {
    data() {
        return {
            posts: []
        }
    },
    template: ` 
    <div id="main-feed">
    <nav-bar></nav-bar>
    <div class="container">
        <add-post defaultType="all"></add-post>
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
            // add get request for posts
            return [{
                    id: 0,
                    user: {
                        name: 'Test',
                        surname: 'Testic',
                        profilePic: "../img/female_avatar.svg",
                        username: "nekoime"
                    },
                    type: 'text',
                    photo: "../img/avatar1.jpg",
                    text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?',
                    comments: [{
                            id: 0,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 1,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 2,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
                    id: 1,
                    user: {
                        name: 'Test',
                        surname: 'Testic',
                        profilePic: "../img/female_avatar.svg",
                        username: "nekoime",
                        username: "nekoime"
                    },
                    type: 'text',
                    photo: "../img/avatar1.jpg",
                    text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?',
                    comments: [{
                            id: 0,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 1,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 2,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
                    id: 2,
                    user: {
                        name: 'Test',
                        surname: 'Testic',
                        profilePic: "../img/female_avatar.svg",
                        username: "nekoime"
                    },
                    type: 'text',
                    photo: "../img/avatar1.jpg",
                    text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?',
                    comments: [{
                            id: 0,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 1,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 2,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
                    id: 3,
                    user: {
                        name: 'Test',
                        surname: 'Testic',
                        profilePic: "../img/female_avatar.svg",
                        username: "nekoime"
                    },
                    type: 'text',
                    photo: "../img/avatar1.jpg",
                    text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?',
                    comments: [{
                            id: 0,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 1,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 2,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
                    id: 4,
                    user: {
                        name: 'Test',
                        surname: 'Testic',
                        profilePic: "../img/female_avatar.svg",
                        username: "nekoime"
                    },
                    type: 'text',
                    photo: "../img/avatar1.jpg",
                    text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas repellendus enim doloremque rem doloribus commodi fugit nam quisquam sequi corporis?',
                    comments: [{
                            id: 0,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 1,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            id: 2,
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg",
                                username: "nekoime"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
            ]
        }
    },
    mounted() {
        this.posts = this.getPosts();
    },
});

// new Vue({}).$mount("#wrapper")
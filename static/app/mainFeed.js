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
            <post v-for="(post, i) in posts" :key="i" :post="posts[i]"/>
        </div>
    </div>
    </div>	 
`,
    methods: {
        getPosts() {
            // add get request for posts
            return [{
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
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
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
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
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
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
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
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                    ],
                },
                {
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
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
                            },
                            text: 'Lor ectetur adipisicing elit. Tempore animi alias laboriosam fugiat, suscipit ipsum! Porro ducimus veritatis laboriosam eveniet.'
                        },
                        {
                            user: {
                                name: 'Test',
                                surname: 'Testic',
                                profilePic: "../img/female_avatar.svg"
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
const LoginForm = { template: '<login></login>' }
const RegisterForm = { template: '<register></register>' }
const ForgotPasswordForm = { template: '<forgot-password></forgot-password>' }
const UserProfilePage = { template: '<user-profile></user-profile>' }
const EditProfile = { template: '<edit-profile></edit-profile>' }
const MyProfile = { template: '<my-profile></my-profile>' }
const NavBar = { template: '<nav-bar></nav-bar>' }
const UserSearchResultPage = { template: '<user-search-page></user-search-page>' }
const MainFeed = { template: '<main-feed></main-feed>' }
const AllPosts = { template: '<posts></posts>' }
const AllPhotos = { template: '<photos></photos>' }
const MyPosts = { template: '<my-posts></my-posts>' }
const MyPhotos = { template: '<my-photos></my-photos>' }
const FriendList = { template: '<friend-list></friend-list>' }
const FriendRequestList = { template: '<friend-request-list></friend-request-list>' }
const MutualFriendsList = { template: '<mutual-friends-list></mutual-friends-list>' }
const Chat = { template: '<chat></chat>' }

const router = new VueRouter({
    mode: 'hash',
    routes: [
        { path: '/', component: MainFeed },
        { path: '/login/', component: LoginForm },
        { path: '/register/', component: RegisterForm },
        { path: '/login/forgot', component: ForgotPasswordForm },
        { path: '/user/:username', component: UserProfilePage },
        { path: '/user/:username/posts', component: AllPosts },
        { path: '/user/:username/photos', component: AllPhotos },
        { path: '/user/:username/mutual-friends', component: MutualFriendsList },
        { path: '/my-profile', component: MyProfile },
        { path: '/edit-profile', component: EditProfile },
        { path: '/user-search-page', name: 'UserSearch', component: UserSearchResultPage },
        { path: '/nav', component: NavBar },
        { path: '/my-posts', component: MyPosts },
        { path: '/my-photos', component: MyPhotos },
        { path: '/friend-list', component: FriendList },
        { path: '/friend-request-list', component: FriendRequestList },
        { path: '/chat', component: Chat },
    ]
});

var app = new Vue({
    router,
    el: '#wrapper'
});
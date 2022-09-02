const LoginForm = { template: '<login></login>' }
const RegisterForm = { template: '<register></register>' }
const ForgotPasswordForm = { template: '<forgot-password></forgot-password>' }
const UserProfilePage = { template: '<user-profile></user-profile>' }
const MyProfile = { template: '<my-profile></my-profile>' }
const NavBar = { template: '<nav-bar></nav-bar>' }
const UserSearchResultPage = { template: '<user-search-page></user-search-page>' }
const MainFeed = { template: '<main-feed></main-feed>' }
const AllPosts = { template: '<posts></posts>' }
const AllPhotos = { template: '<photos></photos>' }
const FriendList = { template: '<friend-list></friend-list>' }
const FriendRequestList = { template: '<friend-request-list></friend-request-list>' }
const MutualFriendsList = { template: '<mutual-friends-list></mutual-friends-list>' }

const router = new VueRouter({
    mode: 'hash',
    routes: [
        { path: '/', component: MainFeed },
        { path: '/login/', component: LoginForm },
        { path: '/register/', component: RegisterForm },
        { path: '/login/forgot', component: ForgotPasswordForm },
        { path: '/user/:username', component: UserProfilePage },
        { path: '/my-profile', component: MyProfile },
        { path: '/user-search-page', name: 'UserSearch', component: UserSearchResultPage },
        { path: '/nav', component: NavBar },
        { path: '/posts', component: AllPosts },
        { path: '/photos', component: AllPhotos },
        { path: '/friend-list', component: FriendList },
        { path: '/mutual-friends', component: MutualFriendsList },
        { path: '/friend-request-list', component: FriendRequestList },
    ]
});

var app = new Vue({
    router,
    el: '#wrapper'
});
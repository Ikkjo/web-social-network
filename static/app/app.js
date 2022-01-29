const LoginForm = { template: '<login></login>' }
const RegisterForm = { template: '<register></register>' }
const ForgotPasswordForm = { template: '<forgot-password></forgot-password>' }
const UserProfilePage = { template: '<user-profile></user-profile>' }
    // const UserSearchDropdown = { template: '<user-search-dropdown></user-search-dropdown>' }
const NavBar = { template: '<nav-bar></nav-bar>' }

const router = new VueRouter({
    mode: 'hash',
    routes: [
        { path: '/', component: LoginForm },
        { path: '/login/', component: LoginForm },
        { path: '/register/', component: RegisterForm },
        { path: '/login/forgot', component: ForgotPasswordForm },
        { path: '/user/profile', component: UserProfilePage },
        // { path: '/search', component: UserSearchDropdown },
        { path: '/nav', component: NavBar },
    ]
});

var app = new Vue({
    router,
    el: '#wrapper'
});
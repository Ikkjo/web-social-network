const LoginForm = { template: '<login></login>' }
const RegisterForm = { template: '<register></register>' }

const router = new VueRouter({
    mode: 'hash',
    routes: [
        { path: '/', component: LoginForm },
        { path: '/login/', component: LoginForm },
        { path: '/register/', component: RegisterForm },
        // { path: '/login/forgot', component: RegisterForm },
    ]
});

var app = new Vue({
    router,
    el: '#wrapper'
});
Vue.component("login", {
    data() { return { form: { username: '', password: '', }, infocus: { username: true, password: true, } } },
    props: ["submitForm"],
    template: `
<div class="container login-container">
    <div class="inner-container">
        <div class="form-container">
            <form class="login-form">
                <h2 class="title">Uloguj se</h2>
                <div class="form-element">
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input v-model="form.username" @focus="inFocus('username')" @blur="outFocus('username')" type="text" placeholder="Korisničko ime" name="username" pattern="^[a-z0-9_-]{3,15}$ " />
                    </div>
                    <div v-show="!isFocused( 'username') && $v.form.username.$invalid " class="alert alert-danger ">Korisničko ime je obavezno.</div>
                </div>
                <div class="form-element ">
                    <div class="input-field ">
                        <i class="fas fa-lock "></i>
                        <input v-model="form.password " @focus="inFocus( 'password') " @blur="outFocus( 'password') " type="password " placeholder="Lozinka " name="password " />
                    </div>
                    <div class="links">
                        <router-link to="/login/forgot">Zaboravljena lozinka?</router-link>
                        <router-link to="/register">Registruj se</router-link>
                    </div>
                    <div class="buttons-div">
                        <input @click="login" :disabled="$v.form.$invalid" type="submit" value="Uloguj se" class="btn solid" />
                        <button class="btn transparent">Nastavi kao gost</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="inner-container picture-container ">
        <span><img src="./img/login.svg " alt=""></span>
    </div>
</div>
`,
    methods: {
        isFocused(field) {
            return this.infocus[field]
        },
        inFocus(field) {
            this.infocus[field] = true
        },
        outFocus(field) {
            this.infocus[field] = false
        },
        login() {
            axios.post("/login/", {
                username: this.form.username,
                password: this.form.password,
            }).then(() => router.push("/profile/"))
            .catch(() => alert("Login neuspješan."))
        }
    },
    mounted() {},
    validations: {
        form: {
            username: { required: validators.required, },
            password: { required: validators.required, },
        }
    }
}); // new Vue({}).$mount("#wrapper ")
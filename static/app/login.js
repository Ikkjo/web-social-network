Vue.component("login", {
    data() {
        return {
            valid: false,
            showPassword: false,
            userInfo: {
                username: '',
                password: '',
            },
        }
    },
    props: ["submitForm"],
    template: ` 
    <div class="container">

    <div class="login-container">
        <form>
            <h2 class="title">Uloguj se</h2>
            <div class="input-field">
            <i class="fas fa-user"></i>
                <input type="text" placeholder="Korisničko ime" name="username"" required/>
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Lozinka" name="password"  required/>
            </div>
            <div class="links">
                <a href="#">Zaboravljena lozinka?</a>
                <a href="#">Registruj se</a>
            </div>
            <input type="submit" value="Uloguj se" class="btn solid" />

            <button class="btn transparent">Nastavi kao gost</button>

        </form>
    </div>
    <div class="picture-container">
        <span><img src="./img/login.svg" alt=""></span>
    </div>
</div>	 
`,
    methods: {},
    mounted() {},
});

new Vue({}).$mount("#wrapper")
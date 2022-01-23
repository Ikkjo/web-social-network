Vue.component("register", {
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

    <div class="register-container">
        <form>
            <h2 class="title">Registruj se</h2>
            <div class="name-surname">
                <div class="input-field ">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Ime" name="name"" required/>
                </div>
                <div></div>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Prezime" name="surname"" required/>
                </div>
            </div>
            <div class="input-field">
            <i class="fas fa-user"></i>
                <input type="text" placeholder="Korisničko ime" name="username"" required/>
            </div>
            <div class="input-field">
                <i class="fas fa-envelope"></i>
                <input type="text" placeholder="Email" name="email"" required/>
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Lozinka" name="password"  required/>
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Potvrdi lozinku" name="password-rep"  required/>
            </div>
            <div class="input-field">
                <i class="fas fa-venus-mars"></i>
                <select name="gender">
                    <option value="male">Muško</option>
                    <option value="female">Žensko</option>
                </select>
            </div>
            <div class="links">
                <p>Već imaš profil?</p>
                <a href="#">Uloguj se</a>
            </div>
            
            <input type="submit" value="Registruj se" class="btn solid" />
            <button class="btn transparent">Nastavi kao gost</button>
        </form>
    </div>
    <div class="picture-container">
        <span><img src="./img/undraw_explore.svg" alt=""></span>
    </div>
</div>	 
`,
    methods: {},
    mounted() {},
});

new Vue({}).$mount("#register")
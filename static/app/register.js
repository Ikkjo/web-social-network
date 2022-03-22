Vue.use(vuelidate.default)

Vue.component("register", {
    data() {
        return {
            form: {
                name: '',
                surname: '',
                username: '',
                email: '',
                password: '',
                confirmPassword: ''
            },
            infocus: {
                name: true,
                surname: true,
                username: true,
                email: true,
                password: true,
                confirmPassword: true,
            }
        }
    },
    props: ["submitForm"],
    template: ` 
    <div class="container flex-container">

        <div class="inner-container">
            <div class="register-form-container">
                <form @submit.prevent>
                    <h2 class="title">Registruj se</h2>
                    <div class="name-surname">
                        <div class="form-element">
                            <div class="input-field ">
                                <i class="fas fa-user"></i>
                                <input v-model="form.name" @focus="inFocus('name')" @blur="outFocus('name')" type="text" placeholder="Ime" name="name" pattern="[a-zA-Z\.]+$"/>
                                </div>
                            <div v-show="!isFocused('name') && $v.form.name.$invalid" class="alert alert-danger">Ime je obavezno.</div>
                        </div>
                        <div></div>
                        <div class="form-element">
                            <div class="input-field">
                                <i class="fas fa-user"></i>
                                <input v-model="form.surname" @focus="inFocus('surname')" @blur="outFocus('surname')" type="text" placeholder="Prezime" name="surname"" pattern="[a-zA-Z\.]+$"/>
                            </div>
                            <div v-show="!isFocused('surname') && $v.form.surname.$invalid" class="alert alert-danger">Prezime je obavezno</div>
                        </div>
                    </div>
                    <div class="form-element">
                        <div class="input-field">
                        <i class="fas fa-user"></i>
                            <input v-model="form.username" @focus="inFocus('username')" @blur="outFocus('username')" type="text" placeholder="Korisničko ime" name="username"" pattern="^[a-z0-9_-]{3,15}$"/>
                        </div>
                        <div v-show="!isFocused('username') && $v.form.username.$invalid" class="alert alert-danger">Korisničko ime je obavezno, (3-15) karaktera.</div>
                    </div>
                    <div class="form-element">
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input v-model="form.email" @focus="inFocus('email')" @blur="outFocus('email')" type="text" placeholder="Email" name="email"/>
                        </div>
                        <div v-show="!isFocused('email') && $v.form.email.$invalid" class="alert alert-danger">Email adresa je obavezna</div>
                    </div>
                    <div class="form-element">
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input v-model="form.password" @focus="inFocus('password')" @blur="outFocus('password')" type="password" placeholder="Lozinka" name="password"/>
                        </div>
                        <div v-show="!isFocused('password') && $v.form.password.$invalid" class="alert alert-danger">Lozinka je obavezna, minimum 4 karaktera.</div>
                    </div>
                    <div class="form-element">
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input v-model="form.confirmPassword" @focus="inFocus('confirmPassword')" @blur="outFocus('confirmPassword')" type="password" placeholder="Potvrdi lozinku" name="confirmPassword"  required/>
                        </div>
                        <div v-show="!isFocused('confirmPassword') && $v.form.confirmPassword.$invalid" class="alert alert-danger">Lozinke se ne podudaraju.</div>
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
                        <router-link to="/login">Uloguj se</router-link>
                    </div>

                    <div class="buttons-div">
                        <input @click="register" :disabled="$v.form.$invalid" type="submit" value="Registruj se" class="btn solid" />
                        <button class="btn transparent">Nastavi kao gost</button>
                    </div>
                </form>
            </div>
        </div>
    <div class="inner-container picture-container">
        <span><img src="./img/undraw_explore.svg" alt=""></span>
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
        register() {
            axios.post("/register/", {
                name: this.form.name,
                surname: this.form.surname,
                username: this.form.username,
                email: this.form.email,
                password: this.form.password,
            }).then(response => router.push("/login/"))
            .catch(error => alert("Registracija neuspješna. Korisničko ime ili email već iskorišten."))
        }
    },
    mounted() {},
    validations: {
        form: {
            username: {
                required: validators.required,
                minLength: validators.minLength(4),
                maxLength: validators.maxLength(20)
            },
            name: {
                required: validators.required,
                minLength: validators.minLength(1),
                maxLength: validators.maxLength(30)
            },
            surname: {
                required: validators.required,
                minLength: validators.minLength(1),
                maxLength: validators.maxLength(30)
            },
            email: {
                required: validators.required,
                email: validators.email,
                maxLength: validators.maxLength(50)
            },
            password: {
                required: validators.required,
                minLength: validators.minLength(4),
                maxLength: validators.maxLength(30)
            },
            confirmPassword: {
                required: validators.required,
                sameAsPassword: validators.sameAs('password')
            }
        }
    }
});

// new Vue({}).$mount("#register")
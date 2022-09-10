Vue.use(vuelidate.default)

Vue.component("edit-profile", {
    data() {
        return {
            user: {
                name: '',
            },
            form: {
                name: '',
                surname: '',
                email: '',
                password: '',
                newPassword: '',
                confirmNewPassword: '',
                gender: '',
                isPrivate: false,
            },
            infocus: {
                name: true,
                surname: true,
                email: true,
                password: true,
                newPassword: true,
                confirmNewPassword: true,
            }
        }
    },
    template: ` 
    <div id="edit-profile">
        <nav-bar></nav-bar>
        <div class="container">
            <div class="name-surname-div">
                <div class="form-element">
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input v-model="form.name" @focus="inFocus('name')" @blur="outFocus('name')" type="text" placeholder="Ime" name="name" pattern="[a-zA-Z\.]+$"/>
                    </div>
                    <div v-show="!isFocused('name') && $v.form.name.$invalid" class="alert alert-danger">Ime je obavezno.</div>
                </div>
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
                    <i class="fas fa-envelope"></i>
                    <input v-model="form.email" @focus="inFocus('email')" @blur="outFocus('email')" type="text" placeholder="Email" name="email"/>
                </div>
                <div v-show="!isFocused('email') && $v.form.email.$invalid" class="alert alert-danger">Email adresa je obavezna</div>
            </div>
            <div class="form-element">
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input v-model="form.password" @focus="inFocus('password')" @blur="outFocus('password')" type="password" placeholder="Trenutna lozinka" name="password"/>
                </div>
                <div v-show="!isFocused('password') && $v.form.password.$invalid" class="alert alert-danger">Lozinka je obavezna, minimum 4 karaktera.</div>
            </div>
            <div class="form-element">
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input v-model="form.newPassword" @focus="inFocus('newPassword')" @blur="outFocus('newPassword')" type="password" placeholder="Nova lozinka" name="newPassword"/>
                </div>
                <div v-show="!isFocused('newPassword') && $v.form.newPassword.$invalid" class="alert alert-danger">Lozinka je obavezna, minimum 4 karaktera.</div>
            </div>
            <div class="form-element">
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input v-model="form.confirmNewPassword" @focus="inFocus('confirmNewPassword')" @blur="outFocus('confirmNewPassword')" type="password" placeholder="Potvrdi novu lozinku" name="confirmNewPassword"  required/>
                </div>
                <div v-show="!isFocused('confirmNewPassword') && $v.form.confirmNewPassword.$invalid" class="alert alert-danger">Lozinke se ne podudaraju.</div>
            </div>
            <div class="input-field">
                <i class="fas fa-venus-mars"></i>
                <select name="gender" v-model="form.gender">
                    <option value="male">Muško</option>
                    <option value="female">Žensko</option>
                </select>
            </div>
            <button :disabled="buttonDisabled" @click="saveChanges" class="btn"><i class="fas fa-save"></i> Sačuvaj promene</button></a>
            <button :disabled="buttonDisabled" @click="discardChanges" class="btn"><i class="fas fa-trash-restore"></i> Odbaci promene</button></a>
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
        saveChanges() {
            let newDetails = {
                name: this.form.name,
                surname: this.form.surname,
                email: this.form.email,
                password: this.form.password,
                newPassword: this.form.newPassword,
                gender: this.form.gender,
                isPrivate: this.form.isPrivate,
                username: this.user.username
            }
            console.log(newDetails)
            axios.put("/edit-profile/", newDetails, {
                    headers: {
                        Authorization: 'Bearer ' + this.user.jwt,
                    },
                }).then((response) => { alert("Podaci su uspešno ažurirani") })
                .catch(() => alert("Greška."));
        },
        discardChanges() {
            this.form.name = JSON.parse(JSON.stringify(this.user.name))
            this.form.surname = JSON.parse(JSON.stringify(this.user.surname))
            this.form.email = JSON.parse(JSON.stringify(this.user.email))
            this.form.gender = JSON.parse(JSON.stringify(this.user.gender))
            this.form.password = ""
            this.form.newPassword = ""
            this.form.confirmNewPassword = ""
            window.location.reload();
        },
    },
    computed: {
        buttonDisabled() {
            return this.form.name === this.user.name &&
                this.form.surname === this.user.surname &&
                this.form.email === this.user.email &&
                !this.form.password && !this.form.newPassword && !this.form.confirmNewPassword &&
                this.form.gender === this.user.gender;
        }
    },
    mounted() {
        if (window.sessionStorage.getItem("jwt")) {
            axios.get("/user", {
                    headers: {
                        Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                    }
                }).then((response) => {
                    this.user = JSON.parse(JSON.stringify(response.data))
                    this.form.name = JSON.parse(JSON.stringify(this.user.name))
                    this.form.surname = JSON.parse(JSON.stringify(this.user.surname))
                    this.form.email = JSON.parse(JSON.stringify(this.user.email))
                })
                .catch(() => alert("Greška"))
        } else {
            this.$router.push("/")
        }

    },
    validations: {
        form: {
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
            newPassword: {
                required: validators.required,
                minLength: validators.minLength(4),
                maxLength: validators.maxLength(30)
            },
            confirmNewPassword: {
                required: validators.required,
                sameAsPassword: validators.sameAs('newPassword')
            }
        }
    }
});

// new Vue({}).$mount("#wrapper")
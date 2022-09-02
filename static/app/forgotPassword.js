Vue.component("forgot-password", {
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
    <div id="forgot-password" class="container flex-container">
    <div class="inner-container forgot-container">
        <form class="forgot-form">
            <h2 class="title">Promeni lozinku</h2>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Nova lozinka" name="password" required/>
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Potvrdi lozinku" name="confirmPassword" required/>
            </div>
            <div class="buttons-div">
                <input type="submit" value="Sačuvaj promenu" class="btn solid" />
            </div>
        </form>
    </div>
    <div class="inner-container picture-container">
    </div>
</div>	 
`,
    methods: {},
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
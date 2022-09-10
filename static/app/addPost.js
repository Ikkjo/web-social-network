Vue.use(vuelidate.default)
Vue.component("add-post", {
    props: {
        defaultType: String,
    },
    data() {
        return {
            post: {
                user: {
                    name: '',
                    surname: '',
                    profilePic: ''
                },
                type: '',
                photo: '',
                text: ''
            },
            infocus: {
                text: true
            }
        }
    },
    template: ` 
    <div id="add-post">
        <div v-if="defaultType==='all'" class="post-type-div">
            <button @click="toggle('text')" class="btn type-btn-left" :class="{ inactive: post.type.toLowerCase() !== 'text' }"><i class="fas fa-comment"></i> Tekst</button></a>
            <button @click="toggle('photo')" class="btn type-btn-right" :class="{inactive: post.type.toLowerCase() !== 'photo'}"><i class="fas fa-image"></i> Slika</button></a>
        </div>
        <user-thumbnail
            :user="post.user"
            :useDate="false" 
            class="user-thumbnail"/>

        <div class="post-container" v-if="(post.type.toLowerCase() === 'text' && defaultType==='all') || defaultType==='text'">
            <textarea
                @focus="inFocus('text')"
                @blur="outFocus('text')"
                v-model="post.text"
                @keyup="textAreaAdjust"   
                type="text"
                placeholder="O čemu razmišljaš?" name="add-comment"/>
            <div v-show="!isFocused('text') && $v.post.text.$invalid" class="alert alert-danger">Tekst je obavezan.</div>
            <img class="post-photo" :src="post.photo">
            <label class="btn" for="photo-input"><i class="fas fa-image"></i> Dodaj sliku</label>
            <input type="file"
                ref="photoUploader"
                @click="resetPhotoUploader"
                @input="addPhoto($event)"
                id="photo-input"
                name="photo-input"
                accept="image/png, image/jpeg">
            <div class="button-div">
                <button :disabled="!post.text.replace(/^\s+|\s+$/g, '') || !post.text.replace(/\\n/g, '')" @click="uploadPost" class="btn btn-right"><i class="fas fa-plus-circle"></i> Objavi</button></a>
            </div>
        </div>

        <div class="post-container" v-if="(post.type.toLowerCase() === 'photo' && defaultType==='all') || defaultType==='photo'">
                <img class="post-photo" :src="post.photo">
                <label class="btn" for="photo-input"><i class="fas fa-image"></i> Dodaj sliku</label>
                <input type="file"
                    ref="photoUploader"
                    @click="resetPhotoUploader"
                    @input="addPhoto($event)"
                    id="photo-input"
                    name="photo-input"
                    accept="image/png, image/jpeg">
            <textarea
                v-model="post.text"
                @keyup="textAreaAdjust"   
                type="text"
                placeholder="Dodaj opis..." name="add-comment"/>
            <div class="button-div">
                <button :disabled="post.photo === ''" @click="uploadPost" class="btn btn-right"><i class="fas fa-plus-circle"></i> Objavi</button></a>
            </div>
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
        textAreaAdjust(event) {
            let area = event.target;
            area.style.height = "1px";
            area.style.height = (25 + area.scrollHeight) + "px";
        },
        toggle(type) {
            if (type.toLowerCase() !== this.post.type.toLowerCase()) {
                this.post.type = type;
                this.post.text = '';
                this.post.photo = '';
            }
        },
        uploadPost() {
            console.log(this.post.user.jwt)
            axios.post("/add-post/", this.post, {
                    headers: {
                        Authorization: 'Bearer ' + this.post.user.jwt,
                    },
                })
                .then((response) => {
                    // Reset the inputs
                    this.post.text = '';
                    this.post.photo = '';
                    this.resetPhotoUploader();
                    this.$emit("addedPost", JSON.parse(JSON.stringify(response.data)));
                })
                .catch(() => alert("Greška."))
        },
        addPhoto(event) {
            console.log('here')
            if (event.target.files.length > 0) {
                let src = URL.createObjectURL(event.target.files[0]);
                this.post.photo = src;
            }
        },
        resetPhotoUploader() {
            this.$refs.photoUploader.value = '';
        },
    },
    mounted() {
        axios.get("/user", {
                headers: {
                    Authorization: 'Bearer ' + JSON.parse(window.sessionStorage.getItem("jwt")).jwt
                }
            }).then((response) => this.post.user = JSON.parse(JSON.stringify(response.data)))
            .catch(() => alert("Greška"))
    },
    validations: {
        post: {
            text: {
                required: validators.required,
                minLength: validators.minLength(1),
                maxLength: validators.maxLength(1000)
            },
        }
    }
});

// new Vue({}).$mount("#wrapper")
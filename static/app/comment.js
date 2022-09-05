Vue.component("comment", {
    props: {
        comment: Object
    },
    data() {
        return {}
    },
    template: ` 
    <div id="comment">
        <user-thumbnail
            :user="comment.user"
            :useDate="false" 
            class="user-thumbnail"/>
        <div class="text-div">{{comment.text}}</div>
    </div>	 
`,
    methods: {},
    mounted() {},
});

// new Vue({}).$mount("#wrapper")
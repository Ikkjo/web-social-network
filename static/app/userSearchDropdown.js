Vue.component("user-search-dropdown", {
    components: {},
    props: {
        useEmail: {
            type: Boolean,
            default: false
        },
    },
    data() {
        return {
            params: {
                name: null,
                surname: null,
                email: null,
                dateRange: null,
            },
            lang: {
                formatLocale: {
                    // MMMM
                    months: ['Januar', 'Februar', 'Mart', 'April', 'Maj', 'Juni', 'Juli', 'Avgust', 'Septembar', 'Oktobar', 'Novembar', 'Decembar'],
                    // MMM
                    monthsShort: ['Jan', 'Feb', 'Mar', 'Apr', 'Maj', 'Jun', 'Jul', 'Avg', 'Sep', 'Okt', 'Nov', 'Dec'],
                    // dddd
                    weekdays: ['Nedelja', 'Ponedeljak', 'Utorak', 'Sreda', 'Četvrtak', 'Petak', 'Subota'],
                    // ddd
                    weekdaysShort: ['Ned', 'Pon', 'Uto', 'Sre', 'Čet', 'Pet', 'Sub'],
                    // dd
                    weekdaysMin: ['Ne', 'Po', 'Ut', 'Sr', 'Če', 'Pe', 'Su'],
                    // first day of week
                    firstDayOfWeek: 0,
                    // first week contains January 1st.
                    firstWeekContainsDate: 1,
                },
                // the calendar header, default formatLocale.weekdaysMin
                days: [],
                // the calendar months, default formatLocale.monthsShort
                months: [],
                // the calendar title of year
                yearFormat: 'YYYY',
                // the calendar title of month
                monthFormat: 'MMM',
                // the calendar title of month before year
                monthBeforeYear: false,
            },
        }

    },
    template: `
<div class="container user-search-container">
    <div class="dropdown">
    <i class="fas fa-search"></i> <span @click="toggleShow">Pretraga korisnika</span>
        <div id="dropdown" class="dropdown-content">
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input v-model="params.name" type="text" placeholder="Ime" name="name"/>
            </div>
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input v-model="params.surname" type="text" placeholder="Prezime" name="surname"/>
            </div>
            <div v-if="useEmail" class="input-field">
                <i class="fas fa-envelope"></i>
                <input v-model="params.email" type="text" placeholder="Email" name="email"/>
            </div>
            <date-picker :lang="lang" v-model="params.dateRange" range format="DD.MM.YYYY" range-separator=" - " class="date-picker"></date-picker>
            <button @click="search" class="btn">Pretraži</button>
        </div>
    </div>
</div>
`,
    methods: {
        toggleShow() {
            document.getElementById("dropdown").classList.toggle("show");
        },
        search() {
            let date = null;
            if (this.params.dateRange && !this.params.dateRange.every(x => x === null)) {
                this.params.dateRange = JSON.stringify([this.params.dateRange[0], this.params.dateRange[1]]);
            }
            if (!this.params.name && !this.params.surname && !this.params.dateRange && (!useEmail || !this.params.email))
                alert("Unesite bar jedan parametar pretrage");
            else {
                router.push({ path: '/user-search-page', name: 'UserSearch', query: this.params });
            }
        }
    },
    mounted() {
        this.params.name = null;
        this.params.surname = null;
        this.params.dateRange = null;
    },
});
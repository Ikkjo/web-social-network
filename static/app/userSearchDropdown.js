Vue.component("user-search-dropdown", {
    components: {},
    data() {
        return {
            name: '',
            surname: '',
            dateRange: null,
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
<div class="container">
    <div class="dropdown">
    <i class="fas fa-search"></i> <span @click="toggleShow">Pretraga korisnika</span>
        <div id="dropdown" class="dropdown-content">
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input v-model="name" type="text" placeholder="Ime" name="name"/>
            </div>
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input v-model="surname" type="text" placeholder="Prezime" name="surname"/>
            </div>
            <date-picker :lang="lang" v-model="dateRange" range class="date-picker"></date-picker>
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
            if (this.dateRange && !this.dateRange.every(x => x === null)){
                date = JSON.stringify([this.dateRange[0].getTime(), this.dateRange[1].getTime()]);
            }
            if (!this.name && !this.surname && !this.dateRange)
                alert("Unesite bar jedan parametar pretrage");
            else {
                axios.get("/user-search/", {
                    params: {
                        name: this.name,
                        surname: this.surname,
                        dateRange: date
                    }
                }).then(response => router.push("/user-search-result/:response"))
                .catch(error => alert("Pretraga neuspješna."));
            }
        }
    },
    mounted() {},
});
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
        <span>Pretraga korisnika</span>
        <div class="dropdown-content">
            <div class="input-field">
            <i class="fas fa-user"></i>
            <input v-model="name" type="text" placeholder="Ime" name="name"/>
            </div>
            <div class="input-field">
            <i class="fas fa-user"></i>
            <input v-model="surname" type="text" placeholder="Prezime" name="surname"/>
            </div>
            <date-picker :lang="lang" v-model="dateRange" range class="date-picker"></date-picker>
        </div>
    </div>
</div>
`,
    methods: {},
    mounted() {},
});
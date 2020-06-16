<!-- Template je HTML parce koda koje ce biti ubaceno u DOM.
Posto se ova komponenta renderuje u main.js, ovaj HTML kod ce zavrsiti umetnut u div sa id-jem app.
Template mora da ima samo jedan root HTML element! -->
<template>
    <!-- root element -->
    <div id="home">

        <!-- Coupons tag je zahtev da se na mestu ovog taga izrenderuje template Coupons komponente.
        Ovaj tag je moguc ako se komponenta doda u listu komponenti (components) u skirpt sekciji.
        v-bind:coupons="coupons" znaci da za komponentu Coupons vezujemo promenljivu coupons
        (iz data() u skript zekciji, ovo je pod navodnicima) pod imenom coupons (ime promenljive je posle ':')-->
        <Coupons v-bind:coupons="coupons" v-on:delete-coupon="deleteCoupon" v-on:delete-shop="deleteShop"/>

        <!-- Na slican nacin umecemo i komponentu AddCoupon (komponenta zaduzena za dodavanje novog kupona).
        v-on:add-coupon="addCoupon" je nacin kako da vezemo addCoupon funkciju na event add-coupon.
        Ukoliko komponenta AddCoupon okine event add-coupon onda ce pozvati fukcija addCoupon koja se nalazi u "methods" -->
        <AddCoupon v-on:add-coupon="addCoupon" v-bind:shops="shops"/>
        <div>
            <input type="text" name="username" v-model="input.username" placeholder="Username"/>
            <input type="text" name="password" v-model="input.password" placeholder="Password"/>
            <input type="text" name="firstName" v-model="firstName" placeholder="Firstname"/>
            <input type="text" name="lastName" v-model="lastName" placeholder="Lastname"/>
            <input type="number" name="id" v-model="id" placeholder="ID"/>
            <select v-model="selected">
                <option value="ADMINISTRATOR">ADMINISTRATOR</option>
                <option value="OPERATOR">OPERATOR</option>
            </select>
            <button v-on:click="add"> ADD</button>

        </div>
    </div>

</template>

<script>
    /* Pre nego sto budemo uopste mogli da koristimo komponente u
    template-u moramo da ih importujemo i zaregistrujemo u "components" */
    import Coupons from "../components/Coupons";
    import AddCoupon from "../components/AddCoupon";

    /* Importovali smo svoja dva modula za klijente. Klijenti ce pozivati BE.
    */
    import axios from 'axios'
    import CouponClient from "@/clients/coupon-client.js"
    import ShopClient from "@/clients/shop-client.js"


    export default {
        name: "home",  // name: Definise ime komponente

        /* components: Lista komponenti. Zaregistruje importovane komponente.
        Ove komponente sada mozemo koristiti u template-u. */
        components: {
            Coupons,
            AddCoupon
        },

        /* data: Mora biti funkcija koja vraca objekat.
        Taj objekat ce sadrzati podatke koje ce ova komponenta koristiti.
        Svi podaci zaregistrovani u data sekciji mogu se pristupiti sa this npr. this.coupons */
        data() {
            return {
                coupons: [],
                shops: [],
                input: {
                    username: "",
                    password: "",
                    firstName: "",
                    lastName: "",
                    id: 0,
                    privLevel: ""

                }
            };

        },

        /* methods: Funkcije dostupne ovoj komponenti cak i u template-u.
        Kao i u data sekciji ovim metodama mozemo pristupiti sa this.*/
        methods: {
            addCoupon(coupon) {
                CouponClient.addCoupon(coupon, this);
            },
            deleteCoupon(id) {
                CouponClient.deleteCoupon(id, this);
            },
            deleteShop(){
                console.log("DSADSADKSAHDKJSAHDHSAGDHA");
                CouponClient.loadCoupons(this);
                ShopClient.loadShops(this)
            },
            add() {
                //alert("User added!")
                //this.$router.replace({ name: "shop2" });
                //this.$refs.table.reload()

                axios.post('http://localhost:8080/rest/users/add', {
                    username: this.input.username,
                    password: this.input.password,
                    firstName: this.firstName,
                    lastName: this.lastName,
                    id: this.id,
                    privLevel: this.selected

                })
                    .then(function () {

                    })
                    .catch(e => {
                        this.errors.push(e)
                    })
            },
        },
        /* created: ovde stavljamo kod koji ce se izvrsiti cim se stranica i komponente ucitaju
         */
        created() {
            CouponClient.loadCoupons(this);
            ShopClient.loadShops(this);
            // this.$bus.$on('userCredentials',(user) => {
            //     console.log(user)
            // })
        }
    };
</script>

<!-- Style je sekcija namenjena za CSS. Ukoliko style poseduje keyword scoped, to znaci da ce
CSS biti primenjen iskljucivo na tu komponentu. -->

<style>
    #app {
        font-family: "Avenir", Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
</style>

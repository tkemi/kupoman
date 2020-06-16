<template>
    <div id="shop">
        <h1>{{shopName}}</h1>
        <button v-on:click="deleteShop(id)">Delete</button>
        <Coupons v-bind:coupons="coupons"/>
    </div>
</template>

<script>
    import CouponClient from "@/clients/coupon-client.js"
    import ShopClient from "@/clients/shop-client.js"
    import Coupons from "../components/Coupons";
    import router from "../router"

    export default {
        name: "Shop",
        components: {
            Coupons,

        },
        props:['shopName','id'],

        data() {
            return {
                coupons: [],
            };
        },
        methods:{
            printShopName(){
                let shopName = this.$route.params.shopName;
                console.log(shopName);
            },
            deleteShop(id){
                ShopClient.deleteShop(id);
                this.$emit("delete-shop");
                router.push({name: 'home'});

            }
        },
        created() {
            this.printShopName();
            CouponClient.loadCouponsForShop(this.shopName,this);
        }
    }
</script>

<style scoped>

</style>
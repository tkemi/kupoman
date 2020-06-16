<template>
  <div>
    <h1>Coupons</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Product Name</th>
          <th>Shop</th>
          <th>New Price</th>
          <th>OldPrice</th>
          <th>Discount</th>
          <th>Valid from</th>
          <th>Valid to</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <!-- v-for sluzi da kreira HTML element <tr> za svaki element u nizu coupons-->
        <tr v-bind:key="coupon.id" v-for="coupon in coupons">
          <td>{{coupon.id}}</td>
          <td>{{ coupon.productName }}</td>
          <td v-on:click="goToShop(coupon.shop.name,coupon.shop.id)">{{ coupon.shop.name }}</td>
          <td>{{ coupon.newPrice }}</td>
          <td>{{ coupon.oldPrice }}</td>
          <td>{{ coupon.discount }}%</td>
          <td>{{ coupon.validFrom }}</td>
          <td>{{ coupon.validTo }}</td>
          <td>
            <button v-on:click="deleteCoupon(coupon.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
<!--    <b-table striped hover :items="coupons">-->
<!--      <b-table-column custom-key="actions">-->
<!--        <button class="button is-small is-light">-->
<!--          Delete-->
<!--        </button>-->
<!--      </b-table-column>-->
<!--    </b-table>-->

  </div>
</template>

<script>
  import router from '../router'
export default {
  name: "Coupons",

  /* props: To su promenljive koje ova komponenta moze da primi od strane drugih komponenti.
  Ovoj komponenti je prosledjena lista kupona koristeci v-bind:coupons od strance App.vue komponente. 
  Ove promenljive mozemo koristiti u template sekciji*/
  props: ["coupons"],

  methods:{
    deleteCoupon(id){
      this.$emit("delete-coupon",id);
    },
    goToShop(shopName,id){
      router.replace({ name: "shop", params: {shopName:shopName,id:id}});
    }
  }
};
</script>

<style scoped>

table {
  border-collapse: collapse;
  margin-bottom: 20px;
}

table, th, td {
  border: 1px solid black;
}

td {
  padding: 0 5px;
}
</style>
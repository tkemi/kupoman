const domainUrl = "http://localhost:8080/rest";

let CouponClient = {
    loadCoupons(comp) {
        fetch(domainUrl + "/coupons")
            .then(function (response) {
                return response.json();
            })
            .then(function (couponsVal) {
                console.log(couponsVal)
                comp.coupons = couponsVal;
            });
    },

    addCoupon(coupon, comp) {  
        fetch(domainUrl + "/coupons", {
          method: "POST",
          headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
          },
          body: JSON.stringify(coupon)
        })
          .then(function(response) {
            return response.json();
          })
          .then(function(coupon) {
            comp.coupons = [...comp.coupons, coupon]
          });
      },

    deleteCoupon(id,comp){
        console.log("ID koji treba da se obrise" + id);
        fetch(domainUrl + "/coupons/"+id, {
            method: "DELETE",
        })
            .then(function() {
                // comp.coupons.forEach(function (c) {
                //     console.log("ids1: " + c.id
                //         + "pName: "+c.productName);
                // });

                var index = comp.coupons.findIndex(c =>c.id == id);
                // console.log("Index kupona: "+ comp.coupons.findIndex(c =>c.id == id));

                comp.coupons.splice(index,1);


                // comp.coupons.forEach(function (c) {
                //     console.log("ids22222222222222222222222: "+c.id);
                // });
            });
    },

    loadCouponsForShop(shopName,comp){
        fetch(domainUrl + "/coupons/"+shopName)
            .then(function (response) {
                return response.json();
            })
            .then(function (couponsVal) {
                console.log(couponsVal)
                comp.coupons = couponsVal;
            });
    }
};


export default CouponClient

const domainUrl = "http://localhost:8080/rest";


let ShopClient = {
    loadShops(comp) {
      fetch(domainUrl + "/shops")
        .then(function(response) {
          return response.json();
        })
        .then(function(shops) {
          comp.shops = shops;
        });
    },
    deleteShop(id){
        console.log("ID koji treba da se obrise" + id);
        fetch(domainUrl + "/shops/"+id, {
            method: "DELETE",
        })
    }
}


export default ShopClient

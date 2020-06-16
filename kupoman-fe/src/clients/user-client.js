const domainUrl = "http://localhost:8080/rest";

let UserClient = {
    loadUser(comp) {
        fetch(domainUrl + "/users")
            .then(function(response) {
                return response.json();
            })
            .then(function(users) {
                comp.users = users;
            });
    }
}


export default UserClient
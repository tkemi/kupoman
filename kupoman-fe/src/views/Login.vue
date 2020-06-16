<template>
    <div id="login">
        <h1>Login</h1>

        <input type="text" name="username" v-model="input.username" placeholder="Username"/>
        <input type="password" name="password" v-model="input.password" placeholder="Password"/>
        <button type="button" v-on:click="login()">Login</button>
    </div>
</template>

<script>
    import router from '../router'
    import axios from 'axios'

    export default {
        name: 'Login',

        data() {
            return {
                input: {
                    username: "",
                    password: ""
                },
                users: [],
            }
        },
        methods: {
            login() {
                var user = {
                    privLevel: "",
                    firstName: "",
                    lastName: "",
                    username: "",
                    password: ""
                };
                if (this.input.username != "" && this.input.password != "") {
                    axios.post('http://localhost:8080/rest/users', {

                        username: this.input.username,
                        password: this.input.password
                    })
                        .then(function (response) {
                            if (response.data != "") {
                                //console.log(response);
                                user.privLevel = response.data.privLevel;
                                user.firstName = response.data.firstName;
                                user.lastName = response.data.lastName;
                                user.username = response.data.username;
                                user.password = response.data.password;
                                    router.replace('home');


                                // this.$bus.$emit('userCredentials', {data:user})
                                console.log(user.firstName);

                                //sada prebaciti na glavnu stranicu i proslijediti
                                //ovaj element
                            } else {
                                alert("Recite admiru da napravi nalog")
                                //neki alert baciti nesto, console.log mozda
                            }
                        })

                        .catch(e => {
                            console.log(e);
                        })


                }
            },
        },
    }
</script>

<style scoped>
    #login {
        width: 500px;
        border: 1px solid #CCCCCC;
        background-color: #FFFFFF;
        margin: auto;
        margin-top: 200px;
        padding: 20px;
    }
</style>
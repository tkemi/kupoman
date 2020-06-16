package domaci.user;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserEndpoint {
    private final UserService userService;

    public UserEndpoint(){
        this.userService = new UserService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(User user){
        return userService.getUser(user);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void makeUser(User user){
        System.out.println(user);
        userService.makeUser(user);
    }
}

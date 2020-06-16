package domaci.shop;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/shops")
public class ShopEndpoint {
    private final ShopService service;

    public ShopEndpoint() {
        this.service = new ShopService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> getShops() {
        return service.getShops();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCoupon(@PathParam("id") Integer id) {
        System.out.println("Coupon id:"+id);
        service.deleteShop(id);

        return Response.ok().build();
    }

}

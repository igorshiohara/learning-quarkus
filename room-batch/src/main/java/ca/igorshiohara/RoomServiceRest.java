package ca.igorshiohara;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/rooms")
@ApplicationScoped
@RegisterRestClient(configKey = "rooms-api")
public interface RoomServiceRest {

    @GET
    List<Room> getAllRooms();

}

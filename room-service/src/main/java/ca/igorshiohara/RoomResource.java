package ca.igorshiohara;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rooms")
public class RoomResource {

    @Inject
    RoomService roomService;

    private final static Logger LOGGER = Logger.getLogger(RoomResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms() {
        LOGGER.info("Starting getAllRooms.");
        return roomService.getAllRooms();
    }

}

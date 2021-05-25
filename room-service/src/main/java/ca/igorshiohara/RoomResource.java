package ca.igorshiohara;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("/rooms")
public class RoomResource {

    @Inject
    RoomService roomService;

    @Inject
    MeterRegistry meterRegistry;

    private final static Logger LOGGER = Logger.getLogger(RoomResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms() {
        Timer timer = Timer.builder("roomservice").tag("method", "getAllRooms").register(meterRegistry);
        long start = System.nanoTime();
        LOGGER.info("Starting getAllRooms.");
        final List<Room> allRooms = roomService.getAllRooms();
        timer.record(System.nanoTime()-start, TimeUnit.NANOSECONDS);
        return allRooms;
    }

}

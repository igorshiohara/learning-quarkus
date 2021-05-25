package ca.igorshiohara;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class RoomResource {

    @Inject
    RoomService roomService;

    @Query("allRooms")
    @Description("Gets all rooms for the hotel")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

}

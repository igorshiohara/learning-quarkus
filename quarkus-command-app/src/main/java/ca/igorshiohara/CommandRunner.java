package ca.igorshiohara;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@QuarkusMain
public class CommandRunner implements QuarkusApplication {

    private static final Logger LOGGER = Logger.getLogger(CommandRunner.class);

    @Inject
    DataSource dataSource;

    @ConfigProperty(defaultValue = "Anonymous", name="application.greeting.recipient")
    private String recipient;

    @Override
    public int run(String... args) throws Exception {
        LOGGER.debug("Starting application");

        String sql = "SELECT NAME, ROOM_NUMBER, BED_INFO FROM ROOM";

        List<Room> rooms = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            try(Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    rooms.add(new Room(rs.getString("NAME"),
                                       rs.getString("ROOM_NUMBER"),
                                       rs.getString("BED_INFO")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rooms.forEach(System.out::println);

        LOGGER.debug("Completing application");
        return 0;
    }

}

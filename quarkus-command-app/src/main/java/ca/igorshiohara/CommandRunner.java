package ca.igorshiohara;

import io.quarkus.arc.Arc;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
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
    EntityManager entityManager;

    @ConfigProperty(defaultValue = "Anonymous", name="application.greeting.recipient")
    private String recipient;

    @Override
    public int run(String... args) throws Exception {
        LOGGER.debug("Starting application");

        Arc.container().requestContext().activate();
        List<Room> rooms = entityManager.createQuery("select r from Room r", Room.class).getResultList();
        rooms.forEach(System.out::println);

        Arc.container().requestContext().deactivate();
        LOGGER.debug("Completing application");
        return 0;
    }

}

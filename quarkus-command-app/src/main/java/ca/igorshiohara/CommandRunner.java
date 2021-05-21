package ca.igorshiohara;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@QuarkusMain
public class CommandRunner implements QuarkusApplication {

    private static final Logger LOGGER = Logger.getLogger(CommandRunner.class);

    @ConfigProperty(defaultValue = "Anonymous", name="application.greeting.recipient")
    private String recipient;

    @Override
    public int run(String... args) throws Exception {
        LOGGER.debug("Starting application");
        LOGGER.info("Hello " + recipient);
        LOGGER.debug("Completing application");
        return 0;
    }

}

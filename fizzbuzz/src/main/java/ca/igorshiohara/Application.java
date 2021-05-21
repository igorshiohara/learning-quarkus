package ca.igorshiohara;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;

@QuarkusMain
public class Application implements QuarkusApplication {

    private FizzBuzzService service;

    private static final Logger LOGGER = Logger.getLogger(Application.class);

    @Inject
    public Application(FizzBuzzService service) {
        this.service = service;
    }

    @Override
    public int run(String... args) throws Exception {
        LOGGER.info("Application started.");
        service.execute(16);
        LOGGER.info("Application completed.");
        return 0;
    }
}

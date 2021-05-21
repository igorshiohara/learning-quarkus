package ca.igorshiohara;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FizzBuzzService {

    @ConfigProperty(defaultValue = "100", name = "fizzbuzz.max_number")
    private int maxNumber;

    private static final Logger LOGGER = Logger.getLogger(FizzBuzzService.class);

    public void execute(int number) {
        for (int i = 1; i <= Math.min(maxNumber,number); i++) {
            LOGGER.debug(fizzBuzz(i));
        }
    }

    public String fizzBuzz(int value) {
        StringBuffer buffer = new StringBuffer();
        if (value % 3 == 0) {
            buffer.append("Fizz");
        }
        if (value % 5 == 0) {
            buffer.append("Buzz");
        }
        if (value % 3 != 0 && value % 5 != 0){
            buffer.append(value);
        }

        return buffer.toString();
    }

}

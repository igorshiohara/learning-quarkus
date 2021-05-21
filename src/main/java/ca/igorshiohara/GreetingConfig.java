package ca.igorshiohara;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingConfig {

    private String recipient = "Igor";

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}

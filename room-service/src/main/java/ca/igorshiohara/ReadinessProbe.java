package ca.igorshiohara;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Readiness
@ApplicationScoped
public class ReadinessProbe implements HealthCheck {

    @Inject
    RoomService roomService;

    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.named("Custom Readiness Check")
                .up()
                .withData("roomCount", roomService.getAllRooms().size())
                .build();
    }

}

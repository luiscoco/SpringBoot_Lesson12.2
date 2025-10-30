package com.example.demo.health;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExternalServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        double value = ThreadLocalRandom.current().nextDouble();
        if (value > 0.1) {
            return Health.up()
                    .withDetail("message", "Service is reachable")
                    .build();
        } else {
            return Health.down()
                    .withDetail("error", "Service is not available")
                    .build();
        }
    }
}


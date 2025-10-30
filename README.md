# SpringBoot_Lesson11.2

## Propmt for the Code Agent (Codex, Gemini Code Assistant or Copilot)

**Context**:

I want to customize the Actuator endpoints in my Spring Boot 3.3 application to provide more specific operational data.

**Task**:

Configure the build to include version information in the /info endpoint.

Implement a custom health indicator that checks for a fictional external service.

**Constraints**:

Use Maven or Gradle.

The /info endpoint should display the project's version from the build file.

The custom health check should be named "ExternalService" and contribute to the /health endpoint's status.

**Steps**:

For the /info endpoint:

a. Modify the pom.xml (for Maven) or build.gradle (for Gradle) to enable the build-info goal for the spring-boot-maven-plugin/spring-boot-gradle-plugin.

**For the custom health check**:

a. Create a new Java class named ExternalServiceHealthIndicator that implements the HealthIndicator interface.

b. The class must be a Spring @Component.

c. In the health() method, implement simple logic:

if a random number is greater than 0.1, return Health.up().withDetail("message", "Service is reachable").build(). Otherwise, return 

Health.down().withDetail("error", "Service is not available").build().

Provide instructions to run the application and curl commands to verify both customizations.

**Deliverables**:

The required plugin configuration for pom.xml or build.gradle.

The full code for ExternalServiceHealthIndicator.java.

curl commands to check the /management/info and /management/health endpoints again to see the new data.

**Acceptance Criteria for your AI-generated code**:

• After a rebuild, running the application and accessing /management/info shows a JSON response containing a build object with the project's version.

• Accessing /management/health now shows a components object containing diskSpace, ping, and the new externalService.

• The status of externalService will be "UP" or "DOWN" based on the logic you implemented, and this will affect the overall application status

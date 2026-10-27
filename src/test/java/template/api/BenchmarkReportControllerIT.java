package template.api;

import org.junit.jupiter.api.Test;
import template.AbstractIT;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

class BenchmarkReportControllerIT extends AbstractIT {

    @Test
    void shouldReturnBenchmarkReport() {
        when()
                .get("/api/v1/benchmark-report")
                .then()
                .statusCode(200)
                .body("executionTimeMillis", greaterThanOrEqualTo(0))
                .body("estimatedMemoryConsumedBytes", greaterThanOrEqualTo(0));
    }

}

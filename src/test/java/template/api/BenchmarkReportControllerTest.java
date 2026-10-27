package template.api;

import org.junit.jupiter.api.Test;
import template.service.ComplianceReportService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.OK;

class BenchmarkReportControllerTest {

    @Test
    void shouldReturnBenchmarkReport() {
        //given service
        var service = mock(ComplianceReportService.class);

        //and controller
        var controller = new BenchmarkReportController(service);

        //when the benchmark report is requested
        var response = controller.getBenchmarkReport();

        //then OK status is returned
        assertEquals(OK, response.getStatusCode());

        //and the response contains the measured time and memory
        assertNotNull(response.getBody());
        assertTrue(response.getBody().getExecutionTimeMillis() >= 0);
        assertTrue(response.getBody().getEstimatedMemoryConsumedBytes() >= 0);

        //and the high-risk report was generated
        verify(service).generateHighRiskReport();
    }

}

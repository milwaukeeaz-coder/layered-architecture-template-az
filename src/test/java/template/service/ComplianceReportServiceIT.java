package template.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import template.AbstractIT;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplianceReportServiceIT extends AbstractIT {

    @Autowired
    private ComplianceReportService service;

    @Test
    void shouldReturnHighRiskUsernamesAggregatedInTheDatabase() {
        assertEquals(List.of("user-a", "user-d"), service.generateHighRiskReport());
    }

}

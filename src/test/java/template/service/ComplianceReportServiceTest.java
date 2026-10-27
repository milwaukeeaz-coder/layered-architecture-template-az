package template.service;

import org.junit.jupiter.api.Test;
import template.repository.AuditLogRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static template.service.ComplianceReportService.HIGH_RISK_SCORE;
import static template.service.ComplianceReportService.MINIMUM_HIGH_RISK_EVENTS;

class ComplianceReportServiceTest {

    @Test
    void shouldGenerateHighRiskReport() {
        //given usernames aggregated by the database
        var usernames = List.of("user-a", "user-d");

        //and repository
        var repository = mock(AuditLogRepository.class);
        when(repository.findHighRiskUsernames(HIGH_RISK_SCORE, MINIMUM_HIGH_RISK_EVENTS)).thenReturn(usernames);

        //and service
        var service = new ComplianceReportService(repository);

        //when the high-risk report is generated
        var result = service.generateHighRiskReport();

        //then the database result is returned unchanged
        assertEquals(usernames, result);

        //and the aggregation was requested once
        verify(repository).findHighRiskUsernames(HIGH_RISK_SCORE, MINIMUM_HIGH_RISK_EVENTS);
    }

}

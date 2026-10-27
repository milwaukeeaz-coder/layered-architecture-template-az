package template.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import template.repository.AuditLogRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ComplianceReportService {

    public static final int HIGH_RISK_SCORE = 70;

    public static final long MINIMUM_HIGH_RISK_EVENTS = 3L;

    private final AuditLogRepository auditLogRepository;

    public List<String> generateHighRiskReport() {
        return auditLogRepository.findHighRiskUsernames(HIGH_RISK_SCORE, MINIMUM_HIGH_RISK_EVENTS);
    }

}

package template.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AuditLogRepository {

    private final AuditLogJpaRepository jpaRepository;

    public List<String> findHighRiskUsernames(int minimumRiskScore, long minimumEventCount) {
        return jpaRepository.findHighRiskUsernames(minimumRiskScore, minimumEventCount);
    }

}

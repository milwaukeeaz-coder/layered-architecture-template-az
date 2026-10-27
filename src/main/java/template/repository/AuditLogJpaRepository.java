package template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static template.repository.Queries.HIGH_RISK_USERNAMES_QUERY;

@Repository
public interface AuditLogJpaRepository extends JpaRepository<AuditLogEntity, Long> {

    @Query(HIGH_RISK_USERNAMES_QUERY)
    List<String> findHighRiskUsernames(@Param("minimumRiskScore") int minimumRiskScore,
                                        @Param("minimumEventCount") long minimumEventCount);

}

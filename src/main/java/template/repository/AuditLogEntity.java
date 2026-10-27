package template.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUDIT_LOG")
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDIT_LOG_GEN")
    @SequenceGenerator(name = "AUDIT_LOG_GEN", sequenceName = "AUDIT_LOG_SEQ", allocationSize = 1)
    private Long id;

    private String username;

    private String action;

    private Integer riskScore;

}

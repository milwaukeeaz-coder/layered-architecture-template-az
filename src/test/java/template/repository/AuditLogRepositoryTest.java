package template.repository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuditLogRepositoryTest {

    @Test
    void shouldFindHighRiskUsernames() {
        //given usernames
        var usernames = List.of("user-a", "user-d");

        //and JPA repository
        var jpaRepository = mock(AuditLogJpaRepository.class);
        when(jpaRepository.findHighRiskUsernames(70, 3L)).thenReturn(usernames);

        //and repository
        var repository = new AuditLogRepository(jpaRepository);

        //when high-risk usernames are requested
        var result = repository.findHighRiskUsernames(70, 3L);

        //then the aggregated usernames are returned
        assertEquals(usernames, result);

        //and the database query was used
        verify(jpaRepository).findHighRiskUsernames(70, 3L);
    }

}

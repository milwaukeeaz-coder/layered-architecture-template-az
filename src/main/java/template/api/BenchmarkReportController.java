package template.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RestController;
import template.api.model.BenchmarkReportDTO;
import template.service.ComplianceReportService;

@RestController
@AllArgsConstructor
public class BenchmarkReportController implements BenchmarkReportApi {

    private final ComplianceReportService service;

    @Override
    public ResponseEntity<BenchmarkReportDTO> getBenchmarkReport() {
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = usedMemory(runtime);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        service.generateHighRiskReport();
        stopWatch.stop();

        long estimatedMemoryConsumedBytes = Math.max(0L, usedMemory(runtime) - memoryBefore);
        BenchmarkReportDTO report = new BenchmarkReportDTO(stopWatch.getTotalTimeMillis(), estimatedMemoryConsumedBytes);
        return ResponseEntity.ok(report);
    }

    private static long usedMemory(Runtime runtime) {
        return runtime.totalMemory() - runtime.freeMemory();
    }

}

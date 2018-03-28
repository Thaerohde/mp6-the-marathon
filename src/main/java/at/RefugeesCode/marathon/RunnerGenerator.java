package at.RefugeesCode.marathon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RunnerGenerator {
    @Value("#{'${runners}'.split(','}")
    private List<String> runnerNames;

    public List<Runner> getrunners() {
        return runnerNames.stream()
                .map(name->new Runner(name))
                .map(runner -> {
                    runner.setTime(puttime(runner));
                    return runner;
                })
                .collect(Collectors.toList());
    }

    private Duration puttime(Runner runner) {

        int number = (int) (Math.random() %3);
        return Duration.ofHours(number);

    }
}

package at.RefugeesCode.marathon;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



//@RequestMapping("/runners")

@RestController

public class RunnerEndpoint {
    private List<Runner> runners = new ArrayList<>();



    @PostMapping("/runners")
    Runner post(@RequestBody Runner runner) {
        runners.add(runner);
        return runner;
    }


    @GetMapping("/runners")
    List<Runner> getAll() {
        return runners;



    }

    @GetMapping("/winner")
    Runner getwinner() {
        return runners.stream()
                .sorted((r1, r2) -> r1.getTime().compareTo(r2.getTime()))
                .findFirst()
                .orElse(new Runner("not found"));
    }


}

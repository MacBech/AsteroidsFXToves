package dk.sdu.mmmi.cbse.scoresystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class ScoringSystem {

    private float totalScore = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }

    @GetMapping("/score")
    public float getScore() {
        return totalScore;
    }

    @GetMapping("/reset")
    public float resetScore() {
        totalScore = 0;
        return totalScore;
    }

    @PutMapping("score/update/{score}")
    public float updateScore(@PathVariable(value = "amount") int amount) {
        totalScore += amount;
        return totalScore;
    }

}

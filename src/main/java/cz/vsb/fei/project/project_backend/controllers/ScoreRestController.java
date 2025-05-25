package cz.vsb.fei.project.project_backend.controllers;

import cz.vsb.fei.project.project_backend.dto.ScoreDTO;
import cz.vsb.fei.project.project_backend.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreRestController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<ScoreDTO> getAllScores() {
        return scoreService.getAllScores();
    }

    @PostMapping
    public ScoreDTO createScore(@RequestBody ScoreDTO scoreDTO) {
        System.out.println("↪ Received ScoreDTO: " + scoreDTO);
        return scoreService.createScore(scoreDTO);
    }
}

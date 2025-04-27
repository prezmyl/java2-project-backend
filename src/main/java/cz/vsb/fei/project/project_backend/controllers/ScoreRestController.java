package cz.vsb.fei.project.project_backend.controllers;


import cz.vsb.fei.project.project_backend.entities.Score;
import cz.vsb.fei.project.project_backend.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController = třída, která vrací data přes HTTP.

@RequestMapping("/api/scores") = cesta endpointu.

@GetMapping = načte všechna skóre.

@PostMapping = uloží nové skóre.
 */

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class ScoreRestController {
    private final ScoreRepository scoreRepository;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreRepository.findAll(); //tady pouziju ty metody co mi poskytuje interface ScoreRepository
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) { //@RequestBody JSON klient pozadavek se prevede na Java objekt, kt. se pak dal pozuiva v kodu
        return scoreRepository.save(score);
    }
}

package cz.vsb.fei.project.project_backend.controllers;

import cz.vsb.fei.project.project_backend.entities.GameSession;
import cz.vsb.fei.project.project_backend.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game-sessions")
@RequiredArgsConstructor
public class GameSessionRestController {

    private final GameSessionRepository gameSessionRepository;

    @GetMapping
    public List<GameSession> getAllGameSessions() {
        return gameSessionRepository.findAll();
    }

    @PostMapping
    public GameSession createGameSession(@RequestBody GameSession gameSession) {
        return gameSessionRepository.save(gameSession);
    }
}

package cz.vsb.fei.project.project_backend.controllers;

import cz.vsb.fei.project.project_backend.dto.GameSessionDTO;
import cz.vsb.fei.project.project_backend.entities.GameSession;
import cz.vsb.fei.project.project_backend.repository.GameSessionRepository;
import cz.vsb.fei.project.project_backend.service.GameSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game-sessions")
@RequiredArgsConstructor
public class GameSessionRestController {

    @Autowired
    private GameSessionService gameSessionService;

    @PostMapping
    public GameSessionDTO create(@RequestBody GameSessionDTO dto) {
        return gameSessionService.createGameSession(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameSessionDTO> get(@PathVariable Long id) {
        return gameSessionService.getGameSession(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<GameSessionDTO> getAll() {
        return gameSessionService.getAllGameSessions();
    }

    @PutMapping("/{id}")
    public GameSessionDTO update(@PathVariable Long id, @RequestBody GameSessionDTO dto) {
        return gameSessionService.updateGameSession(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gameSessionService.deleteGameSession(id);
        return ResponseEntity.noContent().build();
    }

}
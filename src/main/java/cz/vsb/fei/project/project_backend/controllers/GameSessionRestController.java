package cz.vsb.fei.project.project_backend.controllers;

import cz.vsb.fei.project.project_backend.dto.GameSessionDTO;
import cz.vsb.fei.project.project_backend.entities.GameSession;
import cz.vsb.fei.project.project_backend.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game-sessions")
@RequiredArgsConstructor
public class GameSessionRestController {

    @Autowired
    private final GameSessionRepository gameSessionRepository;

    @GetMapping
    public List<GameSession> getAllGameSessions() {
        return gameSessionRepository.findAll();
    }

    @PostMapping
    public GameSessionDTO createGameSession(@RequestBody GameSessionDTO dto) {
        GameSession session = new GameSession();
        session.setGameName(dto.getGameName());

        // Ulož session a tím získáš id
        session = gameSessionRepository.save(session);

        // Sestav DTO pro FE s id
        GameSessionDTO response = new GameSessionDTO();
        response.setId(session.getId());
        response.setGameName(session.getGameName());
        return response;
    }

    // GET /api/game-sessions/{id}
    @GetMapping("/{id}")
    public GameSession getSessionById(@PathVariable Long id) {
        return gameSessionRepository.findById(id).orElseThrow();
    }

    // PUT /api/game-sessions/{id}
    @PutMapping("/{id}")
    public GameSession updateSession(@PathVariable Long id, @RequestBody GameSession updatedSession) {
        GameSession session = gameSessionRepository.findById(id).orElseThrow();
        session.setGameName(updatedSession.getGameName());
        return gameSessionRepository.save(session);
    }

    // DELETE /api/game-sessions/{id}
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        gameSessionRepository.deleteById(id);
    }

}

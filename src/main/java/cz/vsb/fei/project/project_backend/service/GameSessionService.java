package cz.vsb.fei.project.project_backend.service;

import cz.vsb.fei.project.project_backend.dto.GameSessionDTO;
import cz.vsb.fei.project.project_backend.entities.GameSession;
import cz.vsb.fei.project.project_backend.repository.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameSessionService {
    @Autowired
    private GameSessionRepository gameSessionRepository;

    public GameSessionDTO createGameSession(GameSessionDTO dto) {
        GameSession session = new GameSession();
        session.setGameName(dto.getGameName());
        session = gameSessionRepository.save(session);
        return mapToDTO(session);
    }

    public Optional<GameSessionDTO> getGameSession(Long id) {
        return gameSessionRepository.findById(id).map(this::mapToDTO);
    }

    private GameSessionDTO mapToDTO(GameSession session) {
        GameSessionDTO dto = new GameSessionDTO();
        dto.setId(session.getId());
        dto.setGameName(session.getGameName());
        return dto;
    }

    public List<GameSessionDTO> getAllGameSessions() {
        return gameSessionRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public GameSessionDTO updateGameSession(Long id, GameSessionDTO dto) {
        GameSession session = gameSessionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("GameSession not found"));
        session.setGameName(dto.getGameName());
        session = gameSessionRepository.save(session);
        return mapToDTO(session);
    }

    public void deleteGameSession(Long id) {
        gameSessionRepository.deleteById(id);
    }

}

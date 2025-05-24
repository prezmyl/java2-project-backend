package cz.vsb.fei.project.project_backend.service;

import cz.vsb.fei.project.project_backend.dto.ScoreDTO;
import cz.vsb.fei.project.project_backend.entities.Score;
import cz.vsb.fei.project.project_backend.entities.Player;
import cz.vsb.fei.project.project_backend.entities.GameSession;
import cz.vsb.fei.project.project_backend.repository.ScoreRepository;
import cz.vsb.fei.project.project_backend.repository.PlayerRepository;
import cz.vsb.fei.project.project_backend.repository.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameSessionRepository sessionRepository;

    // Vrací všechny score jako DTO
    public List<ScoreDTO> getAllScores() {
        return scoreRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Přidání nového skóre
    public ScoreDTO createScore(ScoreDTO dto) {
        Player player = playerRepository.findById(dto.getPlayerId())
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));
        GameSession session = sessionRepository.findById(dto.getGameSessionId())
                .orElseThrow(() -> new IllegalArgumentException("Session not found"));

        Score score = new Score();
        score.setPoints(dto.getPoints());
        score.setPlayer(player);
        score.setGameSession(session);

        Score saved = scoreRepository.save(score);
        return toDto(saved);
    }

    // Mapování entity -> DTO
    private ScoreDTO toDto(Score score) {
        ScoreDTO dto = new ScoreDTO();
        dto.setId(score.getId());
        dto.setPoints(score.getPoints());

        if (score.getPlayer() != null) {
            dto.setPlayerId(score.getPlayer().getId());
            dto.setPlayerNickname(score.getPlayer().getNickname());
        }

        if (score.getGameSession() != null) {
            dto.setGameSessionId(score.getGameSession().getId());
            dto.setGameSessionName(score.getGameSession().getGameName());
        }
        return dto;
    }
}

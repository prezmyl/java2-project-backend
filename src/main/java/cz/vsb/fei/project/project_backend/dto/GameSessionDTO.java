package cz.vsb.fei.project.project_backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class GameSessionDTO {
    private Long id;
    private String gameName;
    private LocalDateTime date; // nebo String, pokud tak máš v entitě

    // Pokud chceš mít detailní výpis skóre k session (ne nutné pro všechno)
    private List<ScoreDTO> scores;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGameName() { return gameName; }
    public void setGameName(String gameName) { this.gameName = gameName; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public List<ScoreDTO> getScores() { return scores; }
    public void setScores(List<ScoreDTO> scores) { this.scores = scores; }
}

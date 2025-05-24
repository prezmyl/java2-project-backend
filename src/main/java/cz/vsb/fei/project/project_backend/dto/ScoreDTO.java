package cz.vsb.fei.project.project_backend.dto;

public class ScoreDTO {
    private Long id;
    private int points;
    private Long playerId;
    private String playerNickname;
    private Long gameSessionId;
    private String gameSessionName;

    // Gettery & settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }

    public String getPlayerNickname() { return playerNickname; }
    public void setPlayerNickname(String playerNickname) { this.playerNickname = playerNickname; }

    public Long getGameSessionId() { return gameSessionId; }
    public void setGameSessionId(Long gameSessionId) { this.gameSessionId = gameSessionId; }

    public String getGameSessionName() { return gameSessionName; }
    public void setGameSessionName(String gameSessionName) { this.gameSessionName = gameSessionName; }
}

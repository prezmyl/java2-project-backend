package cz.vsb.fei.project.project_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO {
    private Long id;
    private int points;
    private Long playerId;
    private String playerNickname;
    private Long gameSessionId;
    private String gameSessionName;

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "id=" + id +
                ", points=" + points +
                ", playerId=" + playerId +
                ", gameSessionId=" + gameSessionId +
                ", playerNickname='" + playerNickname + '\'' +
                ", gameSessionName='" + gameSessionName + '\'' +
                '}';
    }



}

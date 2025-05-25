package cz.vsb.fei.project.project_backend.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameSessionDTO {
    private Long id;
    private String gameName;
    private LocalDateTime date;

    // pro pripadny detailni vypis score k sesssion
    private List<ScoreDTO> scores;


}

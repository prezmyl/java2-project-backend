package cz.vsb.fei.project.project_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameSessionDTO {
    private Long id;
    private String gameName;
    private LocalDateTime date; // nebo String, pokud tak máš v entitě

    // Pokud chceš mít detailní výpis skóre k session (ne nutné pro všechno)
    private List<ScoreDTO> scores;


}

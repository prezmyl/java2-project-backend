package cz.vsb.fei.project.project_backend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int points;
    private String nick;

    @ManyToOne
    @JoinColumn(name = "game_session_id")
    @JsonBackReference
    private GameSession gameSession;

}

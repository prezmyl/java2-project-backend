package cz.vsb.fei.project.project_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String nickname;

    // Když potřebuješ (volitelné)
    private String firstName;
    private String lastName;


}

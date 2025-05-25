package cz.vsb.fei.project.project_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerDTO {
    private Long id;
    private String nickname;

    // rozsiteni pripadna
    private String firstName;
    private String lastName;


}

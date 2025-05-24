package cz.vsb.fei.project.project_backend.dto;

public class PlayerDTO {
    private Long id;
    private String nickname;

    // Když potřebuješ (volitelné)
    // private String firstName;
    // private String lastName;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    // Pokud budeš mít jména:
    // public String getFirstName() { return firstName; }
    // public void setFirstName(String firstName) { this.firstName = firstName; }
    // public String getLastName() { return lastName; }
    // public void setLastName(String lastName) { this.lastName = lastName; }
}

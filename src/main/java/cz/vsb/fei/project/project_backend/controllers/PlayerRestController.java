package cz.vsb.fei.project.project_backend.controllers;

import cz.vsb.fei.project.project_backend.dto.PlayerDTO;
import cz.vsb.fei.project.project_backend.entities.Player;
import cz.vsb.fei.project.project_backend.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
@RequiredArgsConstructor
public class PlayerRestController {

    @Autowired
    private final PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public PlayerDTO create(@RequestBody PlayerDTO dto) {
        Player player = new Player();
        player.setNickname(dto.getNickname());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());

        // Ulozim hrace a ziskam id
        player = playerRepository.save(player);

        // Sestavi DTO pro FE s id
        PlayerDTO response = new PlayerDTO();
        response.setId(player.getId());
        response.setNickname(player.getNickname());
        response.setFirstName(player.getFirstName());
        response.setLastName(player.getLastName());
        return response;
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player updated) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setNickname(updated.getNickname());
        player.setFirstName(updated.getFirstName());
        player.setLastName(updated.getLastName());
        return playerRepository.save(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerRepository.deleteById(id);
    }

}

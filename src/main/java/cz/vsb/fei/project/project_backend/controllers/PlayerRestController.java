package cz.vsb.fei.project.project_backend.controllers;

import cz.vsb.fei.project.project_backend.entities.Player;
import cz.vsb.fei.project.project_backend.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player")
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
    public Player create(@RequestBody Player player) {
        return playerRepository.save(player);
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

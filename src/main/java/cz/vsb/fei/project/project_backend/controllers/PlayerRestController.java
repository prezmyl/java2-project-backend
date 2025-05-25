package cz.vsb.fei.project.project_backend.controllers;

import cz.vsb.fei.project.project_backend.dto.PlayerDTO;
import cz.vsb.fei.project.project_backend.entities.Player;
import cz.vsb.fei.project.project_backend.repository.PlayerRepository;
import cz.vsb.fei.project.project_backend.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
@RequiredArgsConstructor
public class PlayerRestController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public PlayerDTO create(@RequestBody PlayerDTO dto) {
        return playerService.createPlayer(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> get(@PathVariable Long id) {
        return playerService.getPlayer(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PlayerDTO> getAll() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{id}")
    public PlayerDTO update(@PathVariable Long id, @RequestBody PlayerDTO dto) {
        return playerService.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

}

package cz.vsb.fei.project.project_backend.service;

import cz.vsb.fei.project.project_backend.dto.PlayerDTO;
import cz.vsb.fei.project.project_backend.entities.Player;
import cz.vsb.fei.project.project_backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerDTO createPlayer(PlayerDTO dto) {
        Player player = new Player();
        player.setNickname(dto.getNickname());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player = playerRepository.save(player);
        return mapToDTO(player);
    }

    public Optional<PlayerDTO> getPlayer(Long id) {
        return playerRepository.findById(id).map(this::mapToDTO);
    }

    // mapoing Entity <-> DTO
    private PlayerDTO mapToDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setNickname(player.getNickname());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        return dto;
    }

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO dto) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Player not found"));
        player.setNickname(dto.getNickname());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player = playerRepository.save(player);
        return mapToDTO(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

}

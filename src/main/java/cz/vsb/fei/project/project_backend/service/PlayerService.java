package cz.vsb.fei.project.project_backend.service;

import cz.vsb.fei.project.project_backend.Tools;
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
        player.setNickname(dto.getNickname() != null && !dto.getNickname().isBlank()
                ? dto.getNickname()
                : Tools.randomNick());

        player.setFirstName(dto.getFirstName() != null && !dto.getFirstName().isBlank()
                ? dto.getFirstName()
                : Tools.randomFistName());

        player.setLastName(dto.getLastName() != null && !dto.getLastName().isBlank()
                ? dto.getLastName()
                : Tools.randomLastName());
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

        // Dummy data, pokud pole nene vypneno z FE
        player.setNickname(dto.getNickname() != null && !dto.getNickname().isBlank()
                ? dto.getNickname()
                : Tools.randomNick());

        player.setFirstName(dto.getFirstName() != null && !dto.getFirstName().isBlank()
                ? dto.getFirstName()
                : Tools.randomFistName());

        player.setLastName(dto.getLastName() != null && !dto.getLastName().isBlank()
                ? dto.getLastName()
                : Tools.randomLastName());

        player = playerRepository.save(player);
        return mapToDTO(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

}

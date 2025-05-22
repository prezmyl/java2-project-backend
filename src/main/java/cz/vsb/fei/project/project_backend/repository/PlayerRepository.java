package cz.vsb.fei.project.project_backend.repository;

import cz.vsb.fei.project.project_backend.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}

package cz.vsb.fei.project.project_backend.repository;

import cz.vsb.fei.project.project_backend.entities.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}

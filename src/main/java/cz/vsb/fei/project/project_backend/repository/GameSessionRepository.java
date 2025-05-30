package cz.vsb.fei.project.project_backend.repository;

import cz.vsb.fei.project.project_backend.entities.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}

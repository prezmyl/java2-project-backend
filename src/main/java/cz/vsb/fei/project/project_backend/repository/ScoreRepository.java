package cz.vsb.fei.project.project_backend.repository;

import cz.vsb.fei.project.project_backend.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

// automaticky bude vytvaret metody jako findAll, save() findById atd -> uz se to nemusi rucne
public interface ScoreRepository extends JpaRepository<Score, Long> {

}

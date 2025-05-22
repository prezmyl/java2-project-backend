package cz.vsb.fei.project.project_backend.repository;

import cz.vsb.fei.project.project_backend.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// automaticky bude vytvaret metody jako findAll, save() findById atd -> uz se to nemusi rucne
@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

}

package ap.ibmec.cloud.apcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.ibmec.cloud.apcloud.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    
}

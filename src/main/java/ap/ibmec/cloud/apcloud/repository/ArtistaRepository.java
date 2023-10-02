package ap.ibmec.cloud.apcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.ibmec.cloud.apcloud.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository <Artista, Long> {
    long countById(long id);
}

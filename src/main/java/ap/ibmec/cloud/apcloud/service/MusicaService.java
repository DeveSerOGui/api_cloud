package ap.ibmec.cloud.apcloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ap.ibmec.cloud.apcloud.model.Musica;
import ap.ibmec.cloud.apcloud.exception.MusicaException;
import ap.ibmec.cloud.apcloud.model.Artista;
import ap.ibmec.cloud.apcloud.repository.MusicaRepository;
import ap.ibmec.cloud.apcloud.service.ArtistaService;

@Service
public class MusicaService {

    @Autowired
    MusicaRepository musicaRepository;

    @Autowired
    ArtistaService artistaService;

    public List<Musica> findAll() {
        return this.musicaRepository.findAll();
    }

    public Optional<Musica> getById(long id) {
        return this.musicaRepository.findById(id);
    }

    public Musica create(Musica musica) {
        return this.musicaRepository.save(musica);
    }

    public Musica update(long id, Musica newData) throws Exception {
        Optional<Musica> opMusica = musicaRepository.findById(id);

        if (opMusica.isPresent() == false)
            throw new Exception("Não encontrei a musica a ser atualizado");

        Musica musica = opMusica.get();
        musica.setTitulo(newData.getTitulo());
        musica.setLetra(newData.getLetra());

        this.musicaRepository.save(musica);
        return musica;
    }

    public Musica save(long idArtista, Musica item) throws MusicaException {
        Optional<Artista> opArtista = this.artistaService.findById(idArtista);

        if (opArtista.isPresent() == false) {
            throw new MusicaException("Post não encontrado");
        }

        Artista artista = opArtista.get();
        item.setArtista(artista);
        this.musicaRepository.save(item);
       
        return item;
    }

    public void delete(long id) throws Exception {
        Optional<Musica> opMusica = this.musicaRepository.findById(id);

        if (opMusica.isPresent() == false)
            throw new Exception("Não encontrei a musica a ser atualizado");

        this.musicaRepository.delete(opMusica.get());
    }

}

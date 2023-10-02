package ap.ibmec.cloud.apcloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ap.ibmec.cloud.apcloud.model.Artista;
import ap.ibmec.cloud.apcloud.model.Musica;
import ap.ibmec.cloud.apcloud.repository.ArtistaRepository;
import ap.ibmec.cloud.apcloud.repository.MusicaRepository;
import ap.ibmec.cloud.apcloud.service.ArtistaService;
import ap.ibmec.cloud.apcloud.service.MusicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/artista/{idArtista}/musica")
@Tag(name = "Musica", description = "")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @GetMapping
    @Operation(summary = "Buscando postagens de um artista pelo ID da musica", method = "GET")
    public ResponseEntity<List<Musica>> getAll(@PathVariable("idArtista") long idArtista) {
        try {
            return new ResponseEntity<>(this.musicaRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    @Operation(summary = "Adicionando musica", method = "POST")
    public ResponseEntity<Musica> create(@PathVariable("idArtista") long idArtista, @RequestBody Musica musica) {
        try {

            Optional<Artista> artista = artistaRepository.findById(idArtista);

            if (artista.isPresent() == false)
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            artista.get().addMusica(musica);
            this.artistaRepository.save(artista.get());

            return new ResponseEntity<>(musica, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscando todas as musicas de um artista", method = "GET")
    public ResponseEntity<Musica> getById(@PathVariable("id") long id) {

        Optional<Musica> result = this.musicaRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("{id}")
    public ResponseEntity<Musica> update(@PathVariable("id") long id, @RequestBody Musica musicaNovosDados) {
        Optional<Musica> result = this.musicaRepository.findById(id);
        if (result.isPresent() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Musica MusicaASerAtualizada = result.get();
        MusicaASerAtualizada.setTitulo(musicaNovosDados.getTitulo());
        MusicaASerAtualizada.setLetra(musicaNovosDados.getLetra());
        this.musicaRepository.save(MusicaASerAtualizada);

        return new ResponseEntity<>(MusicaASerAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletando musica", method = "DELETE")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            Optional<Musica> musicaASerExcluida = this.musicaRepository.findById(id);

            if (musicaASerExcluida.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this.musicaRepository.delete(musicaASerExcluida.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
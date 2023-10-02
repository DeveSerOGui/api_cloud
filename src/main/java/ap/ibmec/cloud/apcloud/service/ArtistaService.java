package ap.ibmec.cloud.apcloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ap.ibmec.cloud.apcloud.model.Artista;
import ap.ibmec.cloud.apcloud.repository.ArtistaRepository;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository _artistaRepository;

    public List<Artista> findAll() {
        return this._artistaRepository.findAll();
    }

    public Optional<Artista> findById(long id) {
        return this._artistaRepository.findById(id);
    }
    
    public Optional<Artista> getById(long id) {
        return this._artistaRepository.findById(id);
    }


    public Artista save(Artista artista) throws Exception {
        if (this._artistaRepository.countById(artista.getId()) > 0) {
            throw new Exception("Este ID já existe na base de dados");
        }
        this._artistaRepository.save(artista);
        return artista;
    }

    public Artista update(long id, Artista newData) throws Exception {
        Optional<Artista> result = this._artistaRepository.findById(id);

        if (result.isPresent() == false) {
            throw new Exception("Não encontrei o artista a ser atualizada");
        }

        Artista pessoaASerAtualizada = result.get();
        pessoaASerAtualizada.setNome(newData.getNome());
        this._artistaRepository.save(pessoaASerAtualizada);
        return pessoaASerAtualizada;
    }

    public void delete(long id) throws Exception {
        Optional<Artista> pessoaASerExcluida = this._artistaRepository.findById(id);
        if (pessoaASerExcluida.isPresent() == false) {
            throw new Exception("Não encontrei o artista a ser atualizada");
        }
        this._artistaRepository.delete(pessoaASerExcluida.get());
    }

    public void saveEndereco(Artista artista) {
        this._artistaRepository.save(artista);
    }

}

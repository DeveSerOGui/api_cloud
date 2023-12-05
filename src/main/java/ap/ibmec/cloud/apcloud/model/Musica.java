package ap.ibmec.cloud.apcloud.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "O campo titulo não pode ser vazio")
    private String titulo;

    @Column(name = "letra", nullable = false)
    @NotBlank(message = "O campo letra não pode ser vazio")
    private String letra;

    @Column(name = "Data_da_Publicacao", nullable = false)
    @NotNull(message = "O campo data não pode ser vazio")
    private LocalDate dataPublicacao;

    @ManyToOne
    @JsonIgnore
    private Artista artista;

    @Column(nullable = true)
    private String urlImage;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLetra() {
        return this.letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public LocalDate getDataPublicacao() {
        return this.dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    
    
}

import { MusicasService } from './../../services/musicas.service';
import { Artista } from './../../model/artista.model';
import { ActivatedRoute } from '@angular/router';
import { ArtistaService } from './../../services/artista.service';
import { Component, OnInit } from '@angular/core';
import { Musica } from 'src/app/model/musica';
import { Dialog } from '@angular/cdk/dialog';
import { CreateMusicComponent } from 'src/app/create-music/create-music/create-music.component';

@Component({
  selector: 'app-musicas',
  templateUrl: './musicas.component.html',
  styleUrls: ['./musicas.component.css']
})
export class MusicasComponent implements OnInit {
  artista? : Artista;
  musica?: Musica[];
  showCriarComentario = false;

  constructor(private ArtistaService: ArtistaService, private MusicasService: MusicasService,private route: ActivatedRoute, private dialog : Dialog){

  }

  ngOnInit(): void {

      let idArtista = this.route.snapshot.params["id"];
      this.ArtistaService.getArtistasById(idArtista).subscribe(response => {
        this.artista = response;
      })

      this.MusicasService.getMusicas(idArtista).subscribe(response => {
        this.musica = response;
        console.log(this.musica)
      });

      this.carregarMusica();
  }

  private carregarMusica(){
    let idArtista = this.route.snapshot.params["id"];
    this.MusicasService.getMusicas(idArtista).subscribe(response => {
      this.musica = response;
    })
  }

  public abrirDialogParaNovaMusica(){
    this.showCriarComentario = true;
  }

  public atualizarListaMusica(){
    this.carregarMusica();
  }
}

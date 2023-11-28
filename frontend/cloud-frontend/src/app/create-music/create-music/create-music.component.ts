import { Musica } from './../../model/musica';
import { MusicasService } from './../../services/musicas.service';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-music',
  templateUrl: './create-music.component.html',
  styleUrls: ['./create-music.component.css'],
  providers: []
})
export class CreateMusicComponent {

  titulo = new FormControl('', [Validators.required]);
  letra = new FormControl('', [Validators.required]);
  @Output() newMusicaEvent = new EventEmitter()
  @Input() idArtista:any = '';

  constructor(private MusicasService: MusicasService, private snackBar: MatSnackBar){}

  public criarNovaMusica(){
    if(this.titulo.hasError("required")){
      return;
    }

    if(this.letra.hasError("required")){
      return;
    }

    let musica : Musica = {
      titulo : this.titulo.value as string,
      letra : this.letra.value as string,
      dataPublicacao : new Date()
    }

    this.MusicasService.criarMusica(this.idArtista, musica).subscribe(response => {
      this.snackBar.open("Música criada com sucesso", "Ok");
      this.newMusicaEvent.emit();
    })
  }
}

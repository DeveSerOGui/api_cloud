import { Musica } from './../model/musica';
import { Artista } from './../model/artista.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MusicasService {

  constructor(private http: HttpClient) { }

  public getMusicas(idArtista : any): Observable<Musica[]> {
    return this.http.get<Musica[]>(`https://ibmec-cloud-java.azurewebsites.net/artista/${idArtista}/musica`)
  }

  public criarMusica(idArtista : any, Musica: Musica): Observable<Musica>{
    return this.http.post<Musica>(`https://ibmec-cloud-java.azurewebsites.net/artista/${idArtista}/musica`, Musica)
  }
}

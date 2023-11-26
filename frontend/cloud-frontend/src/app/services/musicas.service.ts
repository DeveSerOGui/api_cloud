import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Musica } from '../model/musica';

@Injectable({
  providedIn: 'root'
})
export class MusicasService {

  constructor(private http: HttpClient) { }

  public getMusicas(idArtista : any): Observable<Musica[]> {
    return this.http.get<Musica[]>(`http://localhost:8080/artista/${idArtista}/musica`)
  }
}

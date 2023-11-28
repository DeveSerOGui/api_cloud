import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Artista } from '../model/artista.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArtistaService {

  constructor(private httpCliente: HttpClient) { }

  public getArtistas() : Observable<Artista[]> {
    return this.httpCliente.get<Artista[]>("https://ibmec-cloud-java.azurewebsites.net/artista");
  }

  public getArtistasById(id: any) : Observable<Artista> {
    //return this.httpCliente.get<Artista>("https://ibmec-cloud-java.azurewebsites.net/artista/" + id);
    return this.httpCliente.get<Artista>("https://ibmec-cloud-java.azurewebsites.net/artista/" + id);
  }
}

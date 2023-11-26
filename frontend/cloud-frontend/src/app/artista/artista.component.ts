import { Router } from '@angular/router';
import { Artista } from '../model/artista.model';
import { ArtistaService } from './../services/artista.service';
import { AfterViewInit, Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-artista',
  templateUrl: './artista.component.html',
  styleUrls: ['./artista.component.css'],
})
export class ArtistaComponent implements OnInit {
  artistas : Artista[] = [];

  constructor(private ArtistaService: ArtistaService, private router : Router) {}

  ngOnInit(): void {
    this.ArtistaService.getArtistas().subscribe(response => {
      this.artistas = response;
    })
  }

  redirectToMusic(id : any) {
    this.router.navigate(["musicas", id])
  }

}

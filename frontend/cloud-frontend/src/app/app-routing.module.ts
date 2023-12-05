import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ArtistaComponent } from './artista/artista.component';
import { MusicasComponent } from './pages/musicas/musicas.component';
import { SobreProjetoComponent } from './pages/sobre-projeto/sobre-projeto.component';

const routes: Routes = [
  { path: "", component: HomeComponent},
  { path: "home", component: HomeComponent},
  { path: "artistas", component: ArtistaComponent},
  { path: "musicas/:id", component: MusicasComponent},
  { path: "sobre", component: SobreProjetoComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

import { Musica } from 'src/app/model/musica';
export interface Artista{
  id?:number;
  nome?:String;
  urlImage?:String;
  musicas:Musica[];
}

import {Component, Input} from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-movie-card',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.scss']
})
export class MovieCardComponent {
  @Input() id!: string; // imdbID é string (ex: tt1201607)
  @Input() year!: string;
  @Input() title!: string;
  @Input() description?: string;
  @Input() poster!: string;

  onImgError(event: Event) {
    (event.target as HTMLImageElement).src = 'https://via.placeholder.com/600x900?text=Imagem+Indisponível';
  }
}

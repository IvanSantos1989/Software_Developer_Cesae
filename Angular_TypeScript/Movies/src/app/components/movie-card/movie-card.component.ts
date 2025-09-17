import {Component, Input, numberAttribute} from '@angular/core';

@Component({
  selector: 'app-movie-card',
  standalone: true,
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.scss']
})
export class MovieCardComponent {
  @Input({transform: numberAttribute}) id!: number;
  @Input() year!: string;
  @Input() title!: string;
  @Input() description!: string;
  @Input() poster!: string;

  onImgError(event: Event) {
    (event.target as HTMLImageElement).src = 'https://via.placeholder.com/600x900?text=Imagem+Indisponível';
  }
}

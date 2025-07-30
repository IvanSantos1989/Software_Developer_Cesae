import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './master-page/header/header.component';
import {FooterComponent} from './master-page/footer/footer.component';
import {CardsComponent} from './components/cards/cards.component';
import {CarouselComponent} from './components/carousel/carousel.component';
import {ImagesComponent} from './components/images/images.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, FooterComponent, CardsComponent, CarouselComponent, ImagesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Audi';
}

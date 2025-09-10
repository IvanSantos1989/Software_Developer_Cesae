import { Component } from '@angular/core';
import {HeaderComponent} from '../../master-page/header/header.component';
import {RouterOutlet} from '@angular/router';
import {FooterComponent} from '../../master-page/footer/footer.component';
import {CarouselComponent} from '../../components/carousel/carousel.component';
import {CardsComponent} from '../../components/cards/cards.component';
import {ImagesComponent} from '../../components/images/images.component';

@Component({
  selector: 'app-home',
  imports: [
    HeaderComponent,
    RouterOutlet,
    FooterComponent,
    CarouselComponent,
    CardsComponent,
    ImagesComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}

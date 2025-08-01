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
  //mainTitle: string = 'Picture Gallery 1';
  mainDescription: string = 'Lorem ipsum Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n' +
    '        Vivamus pulvinar facilisis sem, id cursus dui dictum ac.\n' +
    '        Sed vel tortor ac sapien consequat cursus.\n' +
    '        Nulla facilisi. Donec ac ante nec erat rhoncus commodo.\n' +
    '        Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n' +
    '        Vivamus pulvinar facilisis sem, id cursus dui dictum ac.\n' +
    '        Sed vel tortor ac sapien consequat cursus.\n' +
    '        Nulla facilisi. Donec ac ante nec erat rhoncus commodo.';
  mainImage1: string = 'https://cdn.pixabay.com/photo/2021/06/23/22/02/bmw-6359790_960_720.jpg';


  // mainTitle2: string = 'Picture Gallery 2';
  mainDescription2: string = 'Lorem ipsum Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n' +
    '        Vivamus pulvinar facilisis sem, id cursus dui dictum ac.\n' +
    '        Sed vel tortor ac sapien consequat cursus.\n' +
    '        Nulla facilisi. Donec ac ante nec erat rhoncus commodo.\n' +
    '        Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n' +
    '        Vivamus pulvinar facilisis sem, id cursus dui dictum ac.\n' +
    '        Sed vel tortor ac sapien consequat cursus.\n' +
    '        Nulla facilisi. Donec ac ante nec erat rhoncus commodo.';
  mainImage2: string = 'https://cdn.pixabay.com/photo/2018/02/21/03/15/bmw-m4-3169357_1280.jpg';
}

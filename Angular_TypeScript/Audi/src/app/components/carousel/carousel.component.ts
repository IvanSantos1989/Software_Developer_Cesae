import { Component } from '@angular/core';
import {MdbCarouselModule} from 'mdb-angular-ui-kit/carousel';

@Component({
  selector: 'app-carousel',
  imports: [
    MdbCarouselModule
  ],
  templateUrl: './carousel.component.html',
  styleUrl: './carousel.component.scss'
})
export class CarouselComponent {

}

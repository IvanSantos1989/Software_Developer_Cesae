import { Component, Input } from '@angular/core';
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
  @Input() slideTitle: string = '';
  @Input() slideDescription: string = '';
  @Input() slideImage: string = '';

  @Input() slideTitle2: string = '';
  @Input() slideDescription2: string = '';
  @Input() slideImage2: string = '';

  @Input() slideTitle3: string = '';
  @Input() slideDescription3: string = '';
  @Input() slideImage3: string = '';
}

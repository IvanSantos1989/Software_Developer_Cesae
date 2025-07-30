import { Component } from '@angular/core';
import {CardComponent} from '../card/card.component';

@Component({
  selector: 'app-cards',
  imports: [
    CardComponent
  ],
  templateUrl: './cards.component.html',
  styleUrl: './cards.component.scss'
})
export class CardsComponent {

}

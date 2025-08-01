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
  cardTitle: string = 'card title 1';
  cardDescription: string = 'card description1';
  cardImage: string = 'https://cdn.pixabay.com/photo/2016/12/22/14/41/audi-1925597_640.jpg';
}

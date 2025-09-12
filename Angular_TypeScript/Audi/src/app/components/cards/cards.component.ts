import { Component } from '@angular/core';
import {CardComponent} from '../card/card.component';
import {NgForOf} from '@angular/common';
import {Card} from '../../models/card.model';

@Component({
  selector: 'app-cards',
  imports: [
    CardComponent,
    NgForOf
  ],
  templateUrl: './cards.component.html',
  styleUrl: './cards.component.scss'
})
export class CardsComponent {
  // cardTitle: string = 'card title 1';
  // cardDescription: string = 'card description1';
  // cardImage: string = 'https://cdn.pixabay.com/photo/2016/12/22/14/41/audi-1925597_640.jpg';

  cards: Card[]= [
    {
      title: 'Card Title 1',
      description: 'Card Description 1',
      image: 'https://cdn.pixabay.com/photo/2016/12/22/14/41/audi-1925597_640.jpg'
    },
    {
      title: 'Card Title 2',
      description: 'Card Description 2',
      image: 'https://cdn.pixabay.com/photo/2016/12/08/00/10/audi-1890687_1280.jpg'
    },
    {
      title: 'Card Title 3',
      description: 'Card Description 3',
      image: 'https://cdn.pixabay.com/photo/2021/11/01/21/20/car-6761801_1280.jpg'
    },
  ]
}

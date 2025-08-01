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
  cardImage: string = 'https://cdn.pixabay.com/photo/2018/07/12/16/05/bmw-3533813_1280.jpg';

  cardTitle2: string = 'card title 2';
  cardDescription2: string = 'card description2';
  cardImage2: string = 'https://cdn.pixabay.com/photo/2017/03/07/03/55/bmw-2123139_1280.jpg';

  cardTitle3: string = 'card title 3';
  cardDescription3: string = 'card description3';
  cardImage3: string = 'https://cdn.pixabay.com/photo/2020/06/17/16/13/bmw-5310187_640.jpg';
}

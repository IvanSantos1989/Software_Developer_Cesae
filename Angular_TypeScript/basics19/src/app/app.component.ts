import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {CardComponent} from './card/card.component';
import {CardsComponent} from './cards/cards.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CardComponent, CardsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'basics19';
  firstName: string = 'Ivan';
  lastName: string = 'S. Silva';
}

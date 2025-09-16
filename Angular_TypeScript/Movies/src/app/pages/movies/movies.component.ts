import { Component } from '@angular/core';
import { MoviesListComponent } from '../../components/movies-list/movies-list.component';

@Component({
  selector: 'app-movies',
  standalone: true,
  imports: [MoviesListComponent],
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.scss'
})
export class MoviesComponent {}

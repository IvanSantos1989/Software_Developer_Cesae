import { Routes } from '@angular/router';
import { MoviesComponent } from './pages/movies/movies.component';

export const routes: Routes = [
  { path: '', redirectTo: 'movies', pathMatch: 'full' },
  { path: 'movies', component: MoviesComponent },
  { path: '**', redirectTo: 'movies' }
];

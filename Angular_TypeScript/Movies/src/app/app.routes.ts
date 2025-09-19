import { Routes } from '@angular/router';
import { MoviesComponent } from './pages/movies/movies.component';
import { MovieDetailsComponent } from './components/movie-details/movie-details.component';

export const routes: Routes = [
  { path: '', redirectTo: 'movies', pathMatch: 'full' },
  { path: 'movies', component: MoviesComponent },
  { path: 'movie-details', component: MovieDetailsComponent },
  { path: 'movie-details/:id', component: MovieDetailsComponent },
  { path: '**', redirectTo: 'movies' }
];

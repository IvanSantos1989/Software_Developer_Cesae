import { Component } from '@angular/core';
import { NgForOf } from '@angular/common';
import { Movie } from '../../models/movie.models';
import { MovieCardComponent } from '../movie-card/movie-card.component';

@Component({
  selector: 'app-movies-list',
  standalone: true,
  imports: [NgForOf, MovieCardComponent],
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.scss']
})
export class MoviesListComponent {
  movies: Movie[] = [
    { id: 1,  year: '1994', title: 'The Shawshank Redemption', description: 'Esperança e amizade na prisão.', poster: 'https://m.media-amazon.com/images/I/51NiGlapXlL._AC_.jpg' },
    { id: 2,  year: '1972', title: 'The Godfather',            description: 'Ascensão da família Corleone.', poster: 'https://image.tmdb.org/t/p/original/hMTncCsOwZZCNOo5SBhE1wQKpid.jpg' },
    { id: 3,  year: '2008', title: 'The Dark Knight',          description: 'Batman vs Joker.',               poster: 'https://m.media-amazon.com/images/I/715-qnEMo4L._UF350,350_QL80_.jpg' },
    { id: 4,  year: '1999', title: 'Fight Club',               description: 'Um clube que muda tudo.',        poster: 'https://m.media-amazon.com/images/I/51v5ZpFyaFL._AC_.jpg' },
    { id: 5,  year: '1994', title: 'Pulp Fiction',             description: 'Crime em LA.',                   poster: 'https://m.media-amazon.com/images/I/718LfFW+tIL._UF894,1000_QL80_.jpg' },
    { id: 6,  year: '2001', title: 'The Lord of the Rings: The Fellowship of the Ring', description: 'O início da jornada.', poster: 'https://m.media-amazon.com/images/I/51Qvs9i5a%2BL._AC_.jpg' },
    { id: 7,  year: '1994', title: 'Forrest Gump',             description: 'A vida de Forrest.',             poster: 'https://m.media-amazon.com/images/I/718o2FI-a0L.jpg' },
    { id: 8,  year: '2010', title: 'Inception',                description: 'Ladrão de sonhos.',              poster: 'https://m.media-amazon.com/images/I/61xzvfJiNkL._UF894,1000_QL80_.jpg' },
    { id: 9,  year: '1999', title: 'The Matrix',               description: 'Um hacker descobre a verdade.',  poster: 'https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg' },
    { id:10,  year: '1995', title: 'Se7en',                    description: 'Dois detetives caçam um serial killer.', poster: 'https://m.media-amazon.com/images/I/81PUJbTrztL.jpg' },
  ];
}

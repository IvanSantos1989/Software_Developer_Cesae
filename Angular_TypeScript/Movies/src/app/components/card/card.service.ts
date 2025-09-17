import { Injectable } from '@angular/core';
import { Movie } from '../../models/movie.models';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CardService {
  private domain: string = 'http://www.omdbapi.com/';
  private apiKey: string = '103aad05';

  private movies: Movie[] = [
    {
      Title: 'The Shawshank Redemption',
      Year: '1994',
      imdbID: 'tt0111161',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/51NiGlapXlL._AC_.jpg'
    },
    {
      Title: 'The Godfather',
      Year: '1972',
      imdbID: 'tt0068646',
      Type: 'movie',
      Poster: 'https://image.tmdb.org/t/p/original/hMTncCsOwZZCNOo5SBhE1wQKpid.jpg'
    },
    {
      Title: 'The Dark Knight',
      Year: '2008',
      imdbID: 'tt0468569',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/715-qnEMo4L._UF350,350_QL80_.jpg'
    },
    {
      Title: 'Fight Club',
      Year: '1999',
      imdbID: 'tt0137523',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/51v5ZpFyaFL._AC_.jpg'
    },
    {
      Title: 'Pulp Fiction',
      Year: '1994',
      imdbID: 'tt0110912',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/718LfFW+tIL._UF894,1000_QL80_.jpg'
    },
    {
      Title: 'The Lord of the Rings: The Fellowship of the Ring',
      Year: '2001',
      imdbID: 'tt0120737',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/51Qvs9i5a%2BL._AC_.jpg'
    },
    {
      Title: 'Forrest Gump',
      Year: '1994',
      imdbID: 'tt0109830',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/718o2FI-a0L.jpg'
    },
    {
      Title: 'Inception',
      Year: '2010',
      imdbID: 'tt1375666',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/61xzvfJiNkL._UF894,1000_QL80_.jpg'
    },
    {
      Title: 'The Matrix',
      Year: '1999',
      imdbID: 'tt0133093',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg'
    },
    {
      Title: 'Se7en',
      Year: '1995',
      imdbID: 'tt0114369',
      Type: 'movie',
      Poster: 'https://m.media-amazon.com/images/I/81PUJbTrztL.jpg'
    },
  ];

  constructor(private http:HttpClient) { }

  getMovies(): Movie[] {
    return this.movies;
  }

  addMovie(movie: Movie): void {
    this.movies.push(movie);
  }
}

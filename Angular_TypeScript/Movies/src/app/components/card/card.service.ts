import { Injectable } from '@angular/core';
import {Movie, MoviesResponse, MovieDetails} from '../../models/movie.models';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardService {
  private domain: string = 'https://www.omdbapi.com';
  private apiKey: string = '103aad05';


  constructor(private http:HttpClient) { }

  getMovies(Search: string):Observable<MoviesResponse> {
    return this.http.get<MoviesResponse>(`${this.domain}/?apikey=${this.apiKey}&s=${Search}`);
  }

  getMovieById(id: string): Observable<MovieDetails> {
    return this.http.get<MovieDetails>(`${this.domain}/?apikey=${this.apiKey}&i=${id}`);
  }
}

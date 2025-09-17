import { Component, OnInit } from '@angular/core';
import { NgForOf } from '@angular/common';
import { Movie } from '../../models/movie.models';
import { MovieCardComponent } from '../movie-card/movie-card.component';
import {CardService} from '../card/card.service';

@Component({
  selector: 'app-movies-list',
  standalone: true,
  imports: [NgForOf, MovieCardComponent],
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.scss']
})


export class MoviesListComponent implements OnInit {
  movies: Movie[] = []

  constructor(private cardService:CardService) {}

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.movies = this.cardService.getMovies();
  }


  addMovie(): void {
    const newMovie: Movie = {
      Title: `New Movie ${this.movies.length + 1}`,
      Year: '2023',
      imdbID: `custom${this.movies.length + 1}`,
      Type: 'movie',
      Poster: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQHNwXzDo0Hagh14TqAfGJ0xk0TnYd1S0TKg&s'
    };

    this.cardService.addMovie(newMovie);
    this.getMovies(); // Atualiza a lista após adicionar
  }
}

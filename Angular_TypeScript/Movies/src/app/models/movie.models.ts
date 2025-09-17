// export interface Movie {
//   id: number;
//   year: string;
//   title: string;
//   description: string;
//   poster: string;
// }

export interface MoviesResponse {
  Search: Movie[];
  totalResults: string;
  Response: string;
}

export interface Movie {
  Title: string;
  Year: string;
  imdbID: string;
  Type: string;
  Poster: string;
}

import { Component } from '@angular/core';
import { CardService } from '../card/card.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { MovieDetails } from '../../models/movie.models';

@Component({
  selector: 'app-movie-details',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.scss']
})
export class MovieDetailsComponent {
  movieId: string = '';
  movie: MovieDetails | null = null;
  error: string = '';
  loading: boolean = false;

  constructor(private cardService: CardService, private route: ActivatedRoute, private router: Router) {
    // lê parâmetro de rota e busca automaticamente
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.movieId = id;
        this.searchMovie();
      }
    });
  }

  private isValidId(id: string): boolean {
    return /^tt\d{7,}$/.test(id.trim());
  }

  onKeyUpEnter(): void {
    this.searchMovie();
  }

  goToSearch(): void {
    this.goHome();
  }

  goHome(): void {
    // Agora navega explicitamente para /movies conforme solicitado.
    this.router.navigateByUrl('/movies')
      .catch(() => {
        window.location.href = '/movies';
      });
  }

  searchMovie() {
    this.error = '';
    this.movie = null;
    const id = this.movieId.trim();

    if (!id) {
      this.error = 'Por favor, insira um ID de filme.';
      return;
    }

    if (!this.isValidId(id)) {
      this.error = 'ID inválido. Formato esperado: tt + números (ex: tt1201607).';
      return;
    }

    // Atualiza a URL se o usuário digitou manualmente
    this.router.navigate(['/movie-details', id], { replaceUrl: false });

    this.loading = true;
    this.cardService.getMovieById(id).subscribe({
      next: (data) => {
        if (data && data.Response === 'False') {
          this.error = data.Error || 'Filme não encontrado.';
          this.movie = null;
        } else {
          this.movie = data;
        }
        this.loading = false;
      },
      error: () => {
        this.error = 'Erro ao buscar filme.';
        this.loading = false;
      }
    });
  }
}

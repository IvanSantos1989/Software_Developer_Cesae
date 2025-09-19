import { RenderMode, ServerRoute } from '@angular/ssr';

export const serverRoutes: ServerRoute[] = [
  { path: '', renderMode: RenderMode.Prerender },
  { path: 'movies', renderMode: RenderMode.Prerender },
  { path: 'movie-details', renderMode: RenderMode.Prerender },
  { path: 'movie-details/:id', renderMode: RenderMode.Server },
  { path: '**', renderMode: RenderMode.Server }
];

@extends('layouts.master')
@section('title','Álbuns de '.$band->name)

@section('content')
<h1>Álbuns: {{ $band->name }}</h1>

@auth
  @if(auth()->user()->role === 'admin')
    <p><a href="{{ route('albums.create') }}?band_id={{ $band->id }}">+ Novo Álbum</a></p>
  @endif
@endauth

<table border="1" cellpadding="6">
  <thead>
    <tr>
      <th>Imagem</th>
      <th>Nome</th>
      <th>Lançamento</th>
      <th>Ações</th>
    </tr>
  </thead>
  <tbody>
    @forelse($albums as $album)
      <tr>
        <td>
          @if($album->image_path)
            <img src="{{ asset('storage/'.$album->image_path) }}" width="80">
          @endif
        </td>
        <td>{{ $album->name }}</td>
        <td>{{ optional($album->release_date)->format('Y-m-d') }}</td>
        <td>
          @auth
            <a href="{{ route('albums.edit', $album) }}">Editar</a>
            @if(auth()->user()->role === 'admin')
              <form method="POST" action="{{ route('albums.destroy', $album) }}" style="display:inline">
                @csrf @method('DELETE')
                <button>Apagar</button>
              </form>
            @endif
          @endauth
        </td>
      </tr>
    @empty
      <tr><td colspan="4">Sem álbuns para esta banda.</td></tr>
    @endforelse
  </tbody>
</table>

<p style="margin-top:10px;"><a href="{{ route('bands.index') }}">← Voltar às Bandas</a></p>
@endsection
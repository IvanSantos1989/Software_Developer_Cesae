@extends('layouts.master')
@section('title','Bandas')

@section('content')
<h1>Bandas</h1>

@auth
  @if(auth()->user()->role === 'admin')
    <p><a href="{{ route('bands.create') }}">+ Nova Banda</a></p>
  @endif
@endauth

<table border="1" cellpadding="6">
  <thead>
    <tr>
      <th>Foto</th>
      <th>Nome</th>
      <th># Álbuns</th>
      <th>Ações</th>
    </tr>
  </thead>
  <tbody>
    @forelse($bands as $band)
      <tr>
        <td>
          @if($band->photo_path)
            <img src="{{ asset('storage/'.$band->photo_path) }}" alt="Foto" width="80">
          @endif
        </td>
        <td>{{ $band->name }}</td>
        <td>{{ $band->albums_count }}</td>
        <td>
          <a href="{{ route('bands.albums.index', $band) }}">Ver álbuns</a>
          @auth
            <a href="{{ route('bands.edit', $band) }}">Editar</a>
            @if(auth()->user()->role === 'admin')
              <form method="POST" action="{{ route('bands.destroy', $band) }}" style="display:inline">
                @csrf @method('DELETE')
                <button>Apagar</button>
              </form>
            @endif
          @endauth
        </td>
      </tr>
    @empty
      <tr><td colspan="4">Sem bandas ainda.</td></tr>
    @endforelse
  </tbody>
</table>
@endsection
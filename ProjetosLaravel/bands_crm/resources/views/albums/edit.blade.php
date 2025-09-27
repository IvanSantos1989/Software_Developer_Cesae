@extends('layouts.master')
@section('title','Editar Álbum')

@section('content')
<h1>Editar Álbum</h1>

@if ($errors->any())
  <div style="color:red">
    @foreach($errors->all() as $e) <div>{{ $e }}</div> @endforeach
  </div>
@endif

<form method="POST" action="{{ route('albums.update', $album) }}" enctype="multipart/form-data">
  @csrf @method('PUT')

  <label>Nome: <input type="text" name="name" value="{{ old('name',$album->name) }}" required></label><br>
  <label>Imagem: <input type="file" name="image" accept="image/*"></label><br>
  @if($album->image_path)
    <p>Atual: <img src="{{ asset('storage/'.$album->image_path) }}" width="80"></p>
  @endif
  <label>Lançamento: 
    <input type="date" name="release_date" 
           value="{{ old('release_date', optional($album->release_date)->format('Y-m-d')) }}">
  </label><br>

  <button>Atualizar</button>
</form>
@endsection
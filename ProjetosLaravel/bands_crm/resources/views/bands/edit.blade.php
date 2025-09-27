@extends('layouts.master')
@section('title','Editar Banda')

@section('content')
<h1>Editar Banda</h1>

@if ($errors->any())
  <div style="color:red">
    @foreach($errors->all() as $e) <div>{{ $e }}</div> @endforeach
  </div>
@endif

<form method="POST" action="{{ route('bands.update', $band) }}" enctype="multipart/form-data">
  @csrf @method('PUT')
  <label>Nome: <input type="text" name="name" value="{{ old('name', $band->name) }}" required></label><br>
  <label>Foto: <input type="file" name="photo" accept="image/*"></label><br>
  @if($band->photo_path)
    <p>Atual: <img src="{{ asset('storage/'.$band->photo_path) }}" width="80"></p>
  @endif
  <button>Atualizar</button>
</form>
@endsection
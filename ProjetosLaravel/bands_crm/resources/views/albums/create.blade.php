@extends('layouts.master')
@section('title','Novo Álbum')

@section('content')
<h1>Novo Álbum</h1>

@if ($errors->any())
  <div style="color:red">
    @foreach($errors->all() as $e) <div>{{ $e }}</div> @endforeach
  </div>
@endif

<form method="POST" action="{{ route('albums.store') }}" enctype="multipart/form-data">
  @csrf
  <label>Banda:
    <select name="band_id" required>
      @foreach($bands as $b)
        <option value="{{ $b->id }}" {{ ($selected==$b->id)?'selected':'' }}>{{ $b->name }}</option>
      @endforeach
    </select>
  </label><br>

  <label>Nome: <input type="text" name="name" value="{{ old('name') }}" required></label><br>
  <label>Imagem: <input type="file" name="image" accept="image/*"></label><br>
  <label>Lançamento: <input type="date" name="release_date" value="{{ old('release_date') }}"></label><br>

  <button>Gravar</button>
</form>
@endsection
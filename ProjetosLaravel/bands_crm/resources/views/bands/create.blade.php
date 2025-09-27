@extends('layouts.master')
@section('title','Nova Banda')

@section('content')
<h1>Nova Banda</h1>

@if ($errors->any())
  <div style="color:red">
    @foreach($errors->all() as $e) <div>{{ $e }}</div> @endforeach
  </div>
@endif

<form method="POST" action="{{ route('bands.store') }}" enctype="multipart/form-data">
  @csrf
  <label>Nome: <input type="text" name="name" value="{{ old('name') }}" required></label><br>
  <label>Foto: <input type="file" name="photo" accept="image/*"></label><br>
  <button>Gravar</button>
</form>
@endsection
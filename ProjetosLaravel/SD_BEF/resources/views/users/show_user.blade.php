@extends('layouts.fe_master')

@section('content')
    <h3>User {{$myUser->name}}</h3>

    <h3>Editar User {{ $myUser->name }}</h3>

    <form method="POST" action="{{ route('users.update') }}">
        @csrf
        @method('PUT')
        <input type="hidden" name="id" value="{{ $myUser->id }}">

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nome</label>
            <input required name="name" type="text" class="form-control" id="name" value="{{ $myUser->name }}">
            @error('name')
                nome inválido
            @enderror
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input disabled name="email" type="email" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp" value="{{ $myUser->email }}">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>

        <div class="mb-3">
            <label for="">Morada</label>
            <input type="text" class="form-control" name="address" value="{{ $myUser->address }}">
        </div>

        <div class="mb-3">
            <label for="" class="form-label">Nif</label>
            <input type="text"
            @if ($myUser->nif != 'ainda não tinhamos o nif') readonly @endif
            class="form-control" name="nif" value="{{ $myUser->nif }}">
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
@endsection

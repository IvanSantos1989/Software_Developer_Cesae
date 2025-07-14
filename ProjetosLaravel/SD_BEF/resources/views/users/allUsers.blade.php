@extends('layouts.fe_master')

@section('content')

    <h1>Lista de Utilizadores</h1>

    <ul>
        @foreach($users as $user)
            <li>{{ $user }}</li>
        @endforeach

        <li><a href="{{ route('home') }}">Voltar à Homepage</a></li>
    </ul>

@endsection

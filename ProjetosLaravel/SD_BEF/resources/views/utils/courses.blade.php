@extends('layouts.fe_master')

@section('content')
    <h1>Olá, aqui estão os cursos disponíveis</h1>

    <ul>
        <li>Curso Software Developer </li>
        <li><a href="{{ route('home') }}">Voltar à Homepage</a></li>
    </ul>

@endsection

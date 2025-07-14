@extends('layouts.fe_master')

@section('content')
    @php
        //
    @endphp

    <h1>Sou a tua Homepage</h1>
    <h5>Olá {{ isset($myName) ? $myName : 'Visitante' }}</h5>
    <img src="{{ asset('images/remote.jpg') }}" alt="Homepage Image">

    <ul>
        <li><a href="{{ route('hello') }}">Hello</a></li>
        <li><a href="{{ route('add_user') }}">Adicionar Users</a></li>
        <li><a href="{{ route('allUsers') }}">Ver Lista de Utilizadores</a></li>
        <li><a href="{{ route('courses') }}">Cursos</a></li>

    </ul>

@endsection

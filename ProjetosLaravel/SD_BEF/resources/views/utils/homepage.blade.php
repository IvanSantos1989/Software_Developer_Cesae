@extends('layouts.fe_master')

@section('content')
    @php
        //
    @endphp

    <h1>Sou a tua Homepage</h1>
    <h5>Olá {{ isset($myName) ? $myName : 'Visitante' }}</h5>
    {{-- <h5>o user logado é {{$loginUser['name']}} e o email é {{$loginUser['email']}}</h5> --}}
    <h5>O user logado é o {{$cesaeInfo['name']}} e o email é {{$cesaeInfo['email']}}</h5>
    <img src="{{ asset('images/remote.jpg') }}" alt="Homepage Image">


    <h6>Dados do Cesae</h6>

    <ul>
        <li>Nome: {{ $cesaeInfo['name'] }}</li>
        <li>Endereço: {{ $cesaeInfo['address'] }}</li>
        <li>Email: {{ $cesaeInfo['email'] }}</li>
    </ul>

    <ul>
        <li><a href="{{ route('hello') }}">Hello</a></li>
        <li><a href="{{ route('add_user') }}">Adicionar Users</a></li>
        <li><a href="{{ route('allUsers') }}">Ver Lista de Utilizadores</a></li>
        <li><a href="{{ route('courses') }}">Cursos</a></li>
        <li><a href="{{ route('tasks') }}">Ver Tarefas</a></li>

    </ul>

@endsection

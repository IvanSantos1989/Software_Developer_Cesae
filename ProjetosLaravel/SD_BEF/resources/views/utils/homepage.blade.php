@extends('layouts.fe_master')


@section('content')
    <h1>Sou a tua HomePage</h1>
    <h5>Olá {{ isset($myName) ? $myName : 'Utilizador' }}</h5>
    <h5>O user logado é {{ $loginUser['name'] }} e o email é {{ $loginUser['email'] }}</h5>
    <img src="{{ asset('images/remote.jpg') }}" alt="">

    <h6>Dados do Cesae</h6>
    <ul>
        <li>nome: {{ $cesaeInfo['name'] }}</li>
        <li>morada: {{ $cesaeInfo['address'] }}</li>
    </ul>

    <ul>
        <li><a href="{{ route('hello_route_name') }}">Hello</a></li>
        <li><a href="{{ route('users.add') }}">Adicionar Users</a></li>
        <li><a href="{{ route('users.all') }}">Todos os Users</a></li>
        <li><a href="{{ route('tasks.all') }}">Ver lista de Tarefas</a></li>
        <li><a href="{{ route('tasks.add') }}">Adicionar Tarefa</a></li>
        <li><a href="{{ route('books.all') }}">Oferta de Livros para as Férias</a></li>
        <li><a href="{{ route('books.add') }}">Adicionar um Livro</a></li>
    </ul>
@endsection

@extends('layouts.fe_master')

@section('content')
    <h4>Dashboard - Backoffice</h4>
    <p>Bem-vindo ao painel de administração!</p>

    @if(auth()->user()->user_type == App\Models\User::USER_ADMIN)
    <div class="alert alert-warning" role="alert">
        <strong>Conta de Administrador</strong> - Você tem privilégios de administrador no sistema.
    </div>
    @endif

    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">Olá, {{ auth()->user()->name }}!</h4>
        <p>Está autenticado como: <strong>{{ auth()->user()->email }}</strong></p>
        <hr>
        <p class="mb-0">Aqui pode gerir todas as funcionalidades do sistema.</p>
    </div>

    <hr>
    <h4>Gestão do Sistema</h4>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">Módulo</th>
                <th scope="col">Descrição</th>
                <th scope="col">Ações</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><strong>Livros</strong></td>
                <td>Gerir a oferta de livros para as férias</td>
                <td>
                    <a href="{{ route('books.all') }}" class="btn btn-primary me-2">Ver Livros</a>
                    <a href="{{ route('books.add') }}" class="btn btn-outline-primary">Adicionar</a>
                </td>
            </tr>
            <tr>
                <td><strong>Tarefas</strong></td>
                <td>Gerir todas as tarefas do sistema</td>
                <td>
                    <a href="{{ route('tasks.all') }}" class="btn btn-success me-2">Ver Tarefas</a>
                    <a href="{{ route('tasks.add') }}" class="btn btn-outline-success">Adicionar</a>
                </td>
            </tr>
            <tr>
                <td><strong>Utilizadores</strong></td>
                <td>Gerir utilizadores do sistema</td>
                <td>
                    <a href="{{ route('users.all') }}" class="btn btn-warning me-2">Ver Users</a>
                    <a href="{{ route('users.add') }}" class="btn btn-outline-warning">Adicionar</a>
                </td>
            </tr>
        </tbody>
    </table>

    <ul>
        <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
    </ul>

@endsection

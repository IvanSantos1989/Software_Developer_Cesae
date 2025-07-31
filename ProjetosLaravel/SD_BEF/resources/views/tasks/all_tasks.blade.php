@extends('layouts.fe_master')
@section('content')
    @if (session('message'))
        <div class="alert alert-success">
            {{session('message')}}
        </div>
    @endif

    <h4>Aqui terás todas as tarefas</h4>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Description</th>
                <th scope="col">Nome do Responsável</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($tasks as $task)
                <tr>
                    <th scope="row">{{ $task->id }}</th>
                    <td>{{ $task->name }}</td>
                    <td>{{ $task->description }}</td>
                    <td>{{ $task->username }}</td>
                    <td><a href="{{ route('tasks.show', $task->id) }}" class="btn btn-info me-2">Ver / Editar</a>
                        <a href="{{ route('tasks.delete', $task->id) }}" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach

        </tbody>
    </table>
    <ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
    </ul>
@endsection

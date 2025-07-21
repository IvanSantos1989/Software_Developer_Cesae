@extends('layouts.fe_master')

@section('content')

<h1>Lista de Tarefas</h1>

{{-- <h3>Tarefas Disponíveis:</h3>
@foreach($tasks as $task)
    <p><strong>{{ $task['name'] }}</strong> - {{ $task['task'] }}</p>
@endforeach --}}

<hr>
<h4>Tasks vindas da Base de Dados</h4>

<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nome da Tarefa</th>
            <th scope="col">Estado</th>
            <th scope="col">Data de Conclusão</th>
            <th scope="col">Pessoa Responsável</th>
        </tr>
    </thead>
    <tbody>
        @foreach($tasksFromDB as $task)
        <tr>
            <th scope="row">{{ $task->id }}</th>
            <td>{{ $task->name }}</td>
            <td>{{ $task->status ? 'Concluída' : 'Pendente' }}</td>
            <td>{{ $task->due_at ?? 'Sem data definida' }}</td>
            <td>{{ $task->user_name }}</td>
        </tr>
        @endforeach
    </tbody>
</table>

<ul>
    <li><a href="{{ route('home') }}">Voltar à Homepage</a></li>
</ul>

@endsection

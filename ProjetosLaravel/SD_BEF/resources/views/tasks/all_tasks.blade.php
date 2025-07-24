@extends('layouts.fe_master')
@section('content')
    <h4>Aqui terás todas as tarefas</h4>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Description</th>
                <th scope="col">Nome Responsável</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($tasks as $task)
                <tr>
                    <th scope="row">{{ $task->id }}</th>
                    <td>{{ $task->name }}</td>
                    <td>{{ $task->description }}</td>
                    <td>{{ $task->username }}</td>
                </tr>
            @endforeach


        </tbody>
    </table>
@endsection

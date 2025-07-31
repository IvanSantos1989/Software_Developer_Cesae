@extends('layouts.fe_master')

@section('content')

    <h3>Editar tarefa: {{ $myTask->name }}</h3>

    <form method="POST" action="{{ route('tasks.update') }}">
        @csrf
        @method('PUT')
        <input type="hidden" name="id" value="{{ $myTask->id }}">

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nome da tarefa</label>
            <input required name="name" type="text" class="form-control" id="name" value="{{ $myTask->name }}">
            @error('name')
                nome inválido
            @enderror
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Descrição</label>
            <input name="description" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp" value="{{ $myTask->description }}">
        </div>


        <div class="mb-3">
            <label for="user_id" class="form-label">Nome do Responsável</label>
            <select name="user_id" id="user_id" class="form-select">
                @foreach ($users as $user)
                    <option value="{{ $user->id }}"
                        @if ($myTask->user_id == $user->id) selected @endif>
                        {{ $user->name }}</option>
                @endforeach
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
@endsection

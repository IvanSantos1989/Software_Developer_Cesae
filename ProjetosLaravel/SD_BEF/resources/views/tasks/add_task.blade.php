@extends('layouts.fe_master')

@section('content')

<h1>Aqui podes Adicionar uma tarefa</h1>

<form method="POST" action="{{ route('tasks.store') }}">
    @csrf
<div class="mb-3">
<label for="name" class="form-label">Nome da Tarefa</label>
<input required type="text" class="form-control" name="name" id="name" maxlength="50">
</div>
@error('name')
    <div class="text-danger">{{ $message }}</div>
@enderror

<div class="mb-3">
<label for="description" class="form-label">Descrição da Tarefa</label>
<textarea required class="form-control" name="description" id="description"></textarea>
</div>
@error('description')
    <div class="text-danger">{{ $message }}</div>
@enderror

<div class="mb-3">
<label for="user_id" class="form-label">Utilizador Atribuído</label>
<select required class="form-select" name="user_id" id="user_id">
    <option value="">Selecione um utilizador</option>
    @foreach ($users as $user)
        <option value="{{ $user->id }}">{{ $user->name }}</option>
    @endforeach
</select>
</div>

@error('user_id')
    <div class="text-danger">{{ $message }}</div>
@enderror

<button type="submit" class="btn btn-primary">Adicionar Tarefa</button>
</form>
<ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
</ul>

@endsection

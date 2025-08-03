@extends('layouts.fe_master')

@section('content')

<h1>Adicionar Novo Livro</h1>

<form method="POST" action="{{ route('books.store') }}">
    @csrf
    <div class="mb-3">
        <label for="name" class="form-label">Nome do Livro</label>
        <input required type="text" class="form-control" name="name" id="name">
    </div>
    @error('name')
        <div class="text-danger">{{ $message }}</div>
    @enderror

    <div class="mb-3">
        <label for="estimated_price" class="form-label">Preço Estimado</label>
        <input required type="number" step="0.01" class="form-control" name="estimated_price" id="estimated_price">
    </div>
    @error('estimated_price')
        <div class="text-danger">{{ $message }}</div>
    @enderror

    <div class="mb-3">
        <label for="paid_price" class="form-label">Preço Pago (opcional)</label>
        <input type="number" step="0.01" class="form-control" name="paid_price" id="paid_price">
    </div>
    @error('paid_price')
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

    <button type="submit" class="btn btn-primary">Adicionar Livro</button>
</form>

<ul>
    <li><a href="{{ route('books.all') }}">Voltar à Lista de Livros</a></li>
</ul>

@endsection

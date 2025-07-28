@extends('layouts.fe_master')

@section('content')

<h1>Aqui podes Adicionar Utilizadores</h1>

<form method="POST" action="{{ route('users.store') }}">
    @csrf

<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Nome</label>
<input type="text" class="form-control" name="name" id="name">
</div>
@error('name')
    Nome inválido
@enderror

<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Email address</label>
<input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp">
<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
</div>
@error('email')
    Email inválido
@enderror

<div class="mb-3">
<label for="exampleInputPassword1" class="form-label">Password</label>
<input type="password" class="form-control" name="password" id="password">
</div>

<button type="submit" class="btn btn-primary">Submit</button>
</form>

<ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
</ul>

@endsection

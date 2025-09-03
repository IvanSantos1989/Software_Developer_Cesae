@extends('layouts.fe_master')

@section('content')

<h1>Login</h1>

@if (session('status'))
    <div class="alert alert-success">
        {{ session('status') }}
    </div>
@endif

<form method="POST" action="{{ route('login') }}">
    @csrf

<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Email address</label>
<input required type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp">
<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
</div>
@error('email')
    Email inválido
@enderror

<div class="mb-3">
<label for="exampleInputPassword1" class="form-label">Password</label>
<input required type="password" class="form-control" name="password" id="password">
</div>

<button type="submit" class="btn btn-primary">Login</button>
Esqueceu-se da pass? Clique <a href="{{ route('password.request') }}">aqui</a>
</form>

<ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
</ul>

@endsection

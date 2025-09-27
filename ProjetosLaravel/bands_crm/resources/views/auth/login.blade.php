@extends('layouts.master')

@section('title','Login')

@section('content')
    <h1>Login</h1>

    @if ($errors->any())
        <div style="color:red">
            @foreach($errors->all() as $error)
                <div>{{ $error }}</div>
            @endforeach
        </div>
    @endif

    <form method="POST" action="{{ route('login') }}">
        @csrf
        <label>Email: <input type="email" name="email" required></label><br>
        <label>Password: <input type="password" name="password" required></label><br>
        <label><input type="checkbox" name="remember"> Lembrar</label><br>
        <button type="submit">Entrar</button>
    </form>

    <p style="margin-top:10px;">
        <a href="{{ route('register') }}">Criar conta</a> |
        <a href="{{ route('password.request') }}">Esqueci a senha</a>
    </p>
@endsection
@extends('layouts.master')

@section('title','Registro')

@section('content')
    <h1>Criar Conta</h1>

    @if ($errors->any())
        <div style="color:red">
            @foreach($errors->all() as $error)
                <div>{{ $error }}</div>
            @endforeach
        </div>
    @endif

    <form method="POST" action="{{ route('register') }}">
        @csrf
        <label>Nome: <input type="text" name="name" required></label><br>
        <label>Email: <input type="email" name="email" required></label><br>
        <label>Password: <input type="password" name="password" required></label><br>
        <label>Confirmar Password: <input type="password" name="password_confirmation" required></label><br>
        <button type="submit">Registrar</button>
    </form>

    <p style="margin-top:10px;">
        <a href="{{ route('login') }}">Já tenho conta</a>
    </p>
@endsection
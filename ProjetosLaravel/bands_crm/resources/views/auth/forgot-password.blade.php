@extends('layouts.master')

@section('title','Recuperar Senha')

@section('content')
    <h1>Recuperar Senha</h1>

    @if (session('status'))
        <div style="color:green">{{ session('status') }}</div>
    @endif

    @if ($errors->any())
        <div style="color:red">
            @foreach($errors->all() as $error)
                <div>{{ $error }}</div>
            @endforeach
        </div>
    @endif

    <form method="POST" action="{{ route('password.email') }}">
        @csrf
        <label>Email: <input type="email" name="email" required></label><br>
        <button type="submit">Enviar link de recuperação</button>
    </form>

    <p style="margin-top:10px;"><a href="{{ route('login') }}">Voltar ao login</a></p>
@endsection
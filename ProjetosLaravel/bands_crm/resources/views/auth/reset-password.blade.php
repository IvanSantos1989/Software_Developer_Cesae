@extends('layouts.master')

@section('title','Nova Senha')

@section('content')
    <h1>Definir Nova Senha</h1>

    @if ($errors->any())
        <div style="color:red">
            @foreach($errors->all() as $error)
                <div>{{ $error }}</div>
            @endforeach
        </div>
    @endif

    <form method="POST" action="{{ route('password.update') }}">
        @csrf
        <input type="hidden" name="token" value="{{ $request->route('token') }}">

        <label>Email: <input type="email" name="email" value="{{ old('email') }}" required></label><br>
        <label>Nova Password: <input type="password" name="password" required></label><br>
        <label>Confirmar Password: <input type="password" name="password_confirmation" required></label><br>
        <button type="submit">Atualizar senha</button>
    </form>
@endsection
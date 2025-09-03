@extends('layouts.fe_master')


@section('content')
    <h6>Recuperar Password</h6>
    <form method="POST" action="{{ route('password.email') }}">
        @csrf
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input required name="email" type="email" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            @error('email')
                email inválido
            @enderror
        </div>

        <button type="submit" class="btn btn-primary">Recuperar</button>
    </form>

    <ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
    </ul>

@endsection

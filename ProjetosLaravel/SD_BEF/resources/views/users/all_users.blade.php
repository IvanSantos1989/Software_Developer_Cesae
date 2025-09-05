@extends('layouts.fe_master')
@section('content')
    @if (session('message'))
        <div class="alert alert-success">
            {{session('message')}}
        </div>
    @endif

    <h4>Aqui terás todos os users</h4>
    <h6>Responsável</h6>
    <ul>
        <li>Nome: {{ $courseResp ? $courseResp->name : 'ainda não atribuído' }}</li>
        <li>Email: {{ $courseResp ? $courseResp->email : 'geral@cesae.pt' }}</li>
    </ul>

    <ul>
        @foreach ($users as $user)
            <li>{{ $user['id'] }}: {{ $user['name'] }}</li>
        @endforeach
    </ul>

    <hr>
    <h4>Users vindos da Base de dados</h4>
    <form action="">
        <input type="text" placeholder="Insira o que quer pesquisar" name="search" value="{{request()->query('search')}}">
        <button type="submit" class="btn btn-info">Pesquisar</button>
    </form>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Email</th>
                <th scope="col">NIF</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            @foreach ($usersFromDB as $user)
                <tr>
                    <th scope="row">{{ $user->id }}</th>
                    <td><img width="40px" height="40px"
                            src="{{ $user->photo ? asset('storage/' . $user->photo) : asset('images/nophoto.jpg') }}"
                            alt=""></td>
                    <td>{{ $user->name }}</td>
                    <td>{{ $user->email }}</td>
                    <td>{{ $user->nif }}</td>
                    <td><a href="{{ route('user.show', $user->id) }}" class="btn btn-info me-2">Ver / Editar</a>
                        <a href="{{ route('users.delete', $user->id) }}" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach

        </tbody>
    </table>
    <ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
    </ul>

@endsection

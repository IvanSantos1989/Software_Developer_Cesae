@extends('layouts.fe_master')

@section('content')

    <h1>Lista de Utilizadores</h1>

    <ul>
        @foreach($users as $user)
            <li>{{ $user['id'] }}: {{ $user['name'] }}</li>
        @endforeach

        <hr>
        <h4>Users vindos da Base de Dados</h4>

        <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Email</th>
      <th scope="col">NIF</th>
    </tr>
  </thead>

  <tbody>
    @foreach($usersFromDB as $user)
    <tr>
      <th scope="row">{{ $user->id }}</th>
      <td>{{ $user->name }}</td>
      <td>{{ $user->email }}</td>
      <td>{{ $user->nif }}</td>
    </tr>
    @endforeach
    </tbody>

</table>

        <li><a href="{{ route('home') }}">Voltar à Homepage</a></li>
    </ul>

@endsection

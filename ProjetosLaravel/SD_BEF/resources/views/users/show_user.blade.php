@extends('layouts.fe_master')

@section('content')
    <h3>User {{$myUser->name}}</h3>

    <h6>Nome: {{$myUser->name}}</h6>
    <h6>Morada: {{$myUser->address}}</h6>
    <h6>Nif: {{$myUser->nif}}</h6>
    <h6>Email: {{$myUser->email}}</h6>
@endsection

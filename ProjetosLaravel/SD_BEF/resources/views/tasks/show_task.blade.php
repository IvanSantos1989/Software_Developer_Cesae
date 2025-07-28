@extends('layouts.fe_master')

@section('content')
    <h3>Tarefa: {{$myTask->name}}</h3>

    <h6>Descrição: {{$myTask->description}}</h6>
    <h6>Responsável: {{$myTask->username}}</h6>
    <h6>Criado em: {{$myTask->created_at}}</h6>
    <h6>Atualizado em: {{$myTask->updated_at}}</h6>
@endsection

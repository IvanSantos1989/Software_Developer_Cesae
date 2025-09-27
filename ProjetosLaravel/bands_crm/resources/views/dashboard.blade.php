@extends('layouts.master')
@section('title','Dashboard')
@section('content')
    <h1>Bem-vindo, {{ auth()->user()->name }}</h1>
    <p>Esta é a área protegida do sistema.</p>
@endsection
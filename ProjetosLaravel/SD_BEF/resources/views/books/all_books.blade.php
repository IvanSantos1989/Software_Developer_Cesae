@extends('layouts.fe_master')
@section('content')
    @if (session('message'))
        <div class="alert alert-success">
            {{session('message')}}
        </div>
    @endif

    <h2>Oferta de Livros para as Férias</h2>
    <h4>Aqui terás todos os livros</h4>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Estimativa de Preço</th>
                <th scope="col">Preço Pago</th>
                <th scope="col">User Responsável</th>
                <th scope="col">Diferença</th>
                <th scope="col">Ações</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($books as $book)
                <tr>
                    <th scope="row">{{ $book->id }}</th>
                    <td>{{ $book->name }}</td>
                    <td>{{ $book->estimated_price }}€</td>
                    <td>{{ $book->paid_price ? $book->paid_price . '€' : 'Não pago' }}</td>
                    <td>{{ $book->username }}</td>
                    <td>
                        @if($book->paid_price)
                            @php
                                $diferenca = $book->estimated_price - $book->paid_price;
                            @endphp
                            @if($diferenca > 0)
                                <span class="text-success">+{{ $diferenca }}€ (ganho)</span>
                            @elseif($diferenca < 0)
                                <span class="text-danger">{{ $diferenca }}€ (perda)</span>
                            @else
                                <span class="text-muted">0€ (igual)</span>
                            @endif
                        @else
                            <span class="text-muted">-</span>
                        @endif
                    </td>
                    <td>
                        <a href="{{ route('books.show', $book->id) }}" class="btn btn-info btn-sm me-2">Ver / Editar</a>
                        <a href="{{ route('books.delete', $book->id) }}" class="btn btn-danger btn-sm">Apagar</a>
                    </td>
                </tr>
            @endforeach

        </tbody>
    </table>
    <ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
    </ul>
@endsection

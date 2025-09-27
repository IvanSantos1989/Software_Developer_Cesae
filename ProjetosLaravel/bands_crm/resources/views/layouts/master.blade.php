<!doctype html>
<html lang="pt">
<head>
    <meta charset="utf-8">
    <title>@yield('title','BandsCRM')</title>
</head>
<body>
    <nav>
        <a href="{{ url('/') }}">Home</a> |
        <a href="{{ route('bands.index') }}">Bandas</a> |
        @auth
            <a href="{{ route('dashboard') }}">Dashboard</a> |
            <form method="POST" action="{{ route('logout') }}" style="display:inline">
                @csrf
                <button type="submit">Sair</button>
            </form>
        @else
            <a href="{{ route('login') }}">Entrar</a>
        @endauth
    </nav>
    <hr>
    @if(session('message'))
        <div style="color:green">{{ session('message') }}</div>
    @endif

    @yield('content')
</body>
</html>
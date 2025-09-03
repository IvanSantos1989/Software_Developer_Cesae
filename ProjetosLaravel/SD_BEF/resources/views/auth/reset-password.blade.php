@extends('layouts.fe_master')


@section('content')
<form method="POST" action="{{ route('password.update') }}">
    @csrf
<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Email address</label>
<input name="email" value="{{ request()->email }}" type="email" class="form-control"
               id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
<label for="password" class="form-label">Password</label>
<input type="password" class="form-control @error('password') is-invalid @enderror"
               name="password" />
        @error('password')
<div class="invalid-feedback"></div>
        @enderror
</div>
<div class="mb-3">
<label for="password" class="form-label">Password Confirmation</label>
<input type="password" class="form-control" name="password_confirmation" />
<input type="hidden" name="token" value="{{ request()->route('token') }}">
</div>
<input type="hidden" name="token" value="{{ request()->route('token') }}">
<button type="submit" class="btn btn-primary">Submeter nova password</button>
</form>

<ul>
    <li><a href="{{ route('home_name') }}">Voltar à Homepage</a></li>
</ul>

@endsection

<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', function () {
    return view('welcome');
});

Route::get('/hello', function () {
    return '<h1>Hello World</h1>';
});

Route::get('/course', function () {
    return '<h1>Olá, curso Software Developer</h1>';
});

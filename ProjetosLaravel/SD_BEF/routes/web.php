<?php

use App\Http\Controllers\UtilController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

Route::get('/', [UtilController::class, 'welcome'])->name('welcome');

Route::get('/home', [UtilController::class, 'index'])->name('home');

Route::get('/hello', [UtilController::class, 'hello'])->name('hello');

Route::get('/courses', [UtilController::class, 'courses'])->name('courses');

Route::get('/modules/{name}', function($name){
    return '<h1>Este é o módulo de:'.$name.'</h1>';
});

Route::get('/add_user', [UserController::class, 'addUser'])->name('add_user');

Route::get('/allUsers', [UserController::class, 'allUsers'])->name('allUsers');

Route::fallback(function(){
    return view('utils.fall_back');
});

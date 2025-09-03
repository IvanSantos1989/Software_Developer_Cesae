<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\BookController;
use App\Http\Controllers\TaskController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\UtilController;
use App\Http\Controllers\DashboardController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', [UtilController::class, 'index'])->name('home_name');
Route::get('/hello', [UtilController::class, 'sayHello'])->name('hello_route_name');
Route::get('/curso', function(){
    return '<h1>Olá alunos SD</h1>';
});

Route::get('/modules/{name}', function($name){
    return '<h1>Este é o módulo de:'.$name.'</h1>';
});

/* routes for Users */
//rota que nos vai carregar um formulário para adicionar users
Route::get('/add-users', [UserController::class, 'createUser'])->name('users.add');
Route::post('/store-user', [UserController::class, 'storeUser'])->name('users.store');

//rota que pega nos dados do formulário para fazer um update
Route::put('/update-user', [UserController::class, 'updateUser'])->name('users.update');

Route::get('/users', [UserController::class, 'allUsers'])->name('users.all');
Route::get('/user/{id}', [UserController::class, 'viewUser'])->name('user.show');
Route::get('/delete-user/{id}', [UserController::class, 'deleteUser'])->name('users.delete');


/* routes for Tasks */
Route::get('/tasks', [TaskController::class, 'allTasks'])->name('tasks.all');
Route::get('/task/{id}', [TaskController::class, 'viewTask'])->name('tasks.show');
Route::get('/delete-task/{id}', [TaskController::class, 'deleteTask'])->name('tasks.delete');
Route::get('/add-task', [TaskController::class, 'createTask'])->name('tasks.add');
Route::post('/store-task', [TaskController::class, 'storeTask'])->name('tasks.store');

//rota que pega nos dados do formulário das tasks para fazer um update
Route::put('/update-task', [TaskController::class, 'updateTask'])->name('tasks.update');

// rotas para Books
Route::get('/books', [BookController::class, 'allBooks'])->name('books.all');
Route::get('/book/{id}', [BookController::class, 'viewBook'])->name('books.show');
Route::put('/update-book', [BookController::class, 'updateBook'])->name('books.update');
Route::get('/delete-book/{id}', [BookController::class, 'deleteBook'])->name('books.delete');
Route::get('/add-book', [BookController::class, 'createBook'])->name('books.add');
Route::post('/store-book', [BookController::class, 'storeBook'])->name('books.store');

// rota dashboard - protegida por middleware de autenticação
Route::get('/dashboard', [DashboardController::class, 'index'])->name('dashboard')->middleware('auth');

/* routes for testing proposes */
Route::get('/test-queries', [UserController::class, 'testSqlQueries']);


Route::fallback(function(){
    return "<a href=".route('hello_route_name').">Estás perdido?</a>";
});

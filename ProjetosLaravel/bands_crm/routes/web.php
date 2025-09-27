<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\BandController;
use App\Http\Controllers\AlbumController;

Route::view('/', 'welcome');

// BANDAS
// Público: listar
Route::resource('bands', BandController::class)->only(['index']);

// Autenticado: editar/atualizar
Route::middleware('auth')->group(function () {
    Route::resource('bands', BandController::class)->only(['edit','update']);
    Route::view('/dashboard', 'dashboard')->name('dashboard');
});

// Admin: criar/guardar/apagar
Route::middleware(['auth','admin'])->group(function () {
    Route::resource('bands', BandController::class)->only(['create','store','destroy']);
});

// ÁLBUNS
// Público: ver álbuns de uma banda
Route::get('bands/{band}/albums', [AlbumController::class, 'index'])
    ->name('bands.albums.index');

// Autenticado: editar/atualizar
Route::middleware('auth')->group(function () {
    Route::resource('albums', AlbumController::class)->only(['edit','update']);
});

// Admin: criar/guardar/apagar
Route::middleware(['auth','admin'])->group(function () {
    Route::resource('albums', AlbumController::class)->only(['create','store','destroy']);
});
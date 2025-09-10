<?php

use App\Http\Controllers\TaskAPIController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;


Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

//Route::get('/task/{task}', [TaskAPIController::class, 'show']);

Route::apiResource('/task', TaskAPIController::class);

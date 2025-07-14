<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function addUser() {
        return view('users.add_user');
    }

    public function allUsers() {
        //simula ir a base de dados para buscar os utilizadores
        $users = $this->getUser();
        return view('users.allUsers', compact('users'));
    }

    private function getUser() {
        // query á base de dados para buscar o user
        $users = ['Ivan', 'Maria', 'João'];
        return $users;
    }
}

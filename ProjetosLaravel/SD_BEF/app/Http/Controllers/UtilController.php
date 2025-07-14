<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UtilController extends Controller
{
   public function index() {

        $myName = $this->getUser();
        return view('utils.homepage', compact('myName'));
    }

    public function welcome() {
        return view('welcome');
    }

    public function hello() {
        $myName = $this->getUser();
        return view('utils.hello', compact('myName'));
    }

    public function courses() {
        $myName = $this->getUser();
        return view('utils.courses', compact('myName'));
    }

    private function getUser() {
        // query á base de dados para buscar o user
        $myName = 'Ivan';
        return $myName;
    }


}

<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UtilController extends Controller
{
    public function index() {

        $myName = $this->getUser();

        $loginUser = [
            'name' =>'Ivan',
            'email' => 'ivandev@gmail.com.pt',
            'phone' => '999-999-999',
        ];

        $cesaeInfo = $this->getCesaeInfo();

        return view('utils.homepage', compact('myName', 'loginUser','cesaeInfo'));
    }

    public function sayHello(){
        $myName = $this->getUser();
        return view('utils.hello', compact('myName'));
    }

    private function getUser(){
        //query à base de dados para buscar o user
        $myName = 'Ivan';
        return $myName;

    }

    private function getCesaeInfo(){

        //simula dinamicamente ir à base de dados
        return $cesaeInfo = [
            'name' => 'Cesae',
            'address' => 'Rua do Cesae - Porto'
        ];
    }

}

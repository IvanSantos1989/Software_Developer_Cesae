<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UtilController extends Controller
{
   public function index() {

        $myName = $this->getUser();

        $loginUser = [
            'name' =>'Ivan',
            'email' => 'ivan@gmail.com',
            'phone' => '123456789'
        ];

        $cesaeInfo = $this->getCesaeInfo();

        return view('utils.homepage', compact('myName', 'loginUser', 'cesaeInfo'));
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

    //simula dinamicamente a informação do CESAE
    //poderia ser uma query á base de dados
    private function getCesaeInfo() {
        $cesaeInfo = [
            'name' => 'CESAE',
            'address' => 'Rua Ciriaco 186, 4150-212 Porto',
            'email' => 'cesae@cesae.pt'
        ];
        return $cesaeInfo;
    }

}

<?php
    $helloWorld = 'Aqui vamos trabalhar com o servidor!';
    $helloWorld = 'Aqui vamos trabalhar com o servidor e ligar a web a banco de dados!';

    $name = 'Ivan';

    //definir uma função em php
    function plus($x, $y){
        return $x + $y;
    }

    function fullname($firstName, $lastName){
        return $firstName . ' ' . $lastName;
    }

    //definir um array
    //vida real: vai a BD buscar os dados e select users from users
    $students = ['Rui', 'Eliane', 'Pedro'];
    //var_dump($students); //para ver o que está dentro do array

    $modules = [
        'OOP' => 'Vitor',
        'Design Patterns' => 'Vitor',
        'WEB' => 'Laís',
        'Sql' => 'Alexandre',
         'Programação Servidor' => 'Alexandre'
    ];

    //ir ao ficheiro json e buscar os dados
    $cesaeData = file_get_contents('./data/courses.json');
    $cesaeData = json_decode($cesaeData, true); //true para transformar em array que o PHP entende

    //var_dump($cesaeData['data']);
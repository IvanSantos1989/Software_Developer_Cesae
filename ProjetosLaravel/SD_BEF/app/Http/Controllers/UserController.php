<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class UserController extends Controller
{
    public function addUser() {
        return view('users.add_user');
    }

    public function allUsers() {
        //simula ir a base de dados para buscar os utilizadores
        $users = $this->getUser();

        //ir de forma real a base de dados carregar todos os users
        $usersFromDB = $this->getUsersFromDB();
        //dd($users);

        //carrega a view com os $users e $usersFromDB
        return view('users.allUsers', compact('users', 'usersFromDB'));
    }

    public function testSqlQueries(){

        // DB::table('users')->insert([
        //     'name' => 'Santos',
        //     'email' => 'santos@example.com',
        //     'password' => 'pass123',
        // ]);

        //query de update. no futuro, os dados a actualizar vêm do formulário (resquest)
        // DB::table('users')
        // ->where('id', 1)
        // ->update([
        //     'name' => 'Rita',
        //     'address'=> 'Rua da Rita',
        //     'updated_at' => now()
        // ]);

        //update or insert
        //se tiver o email, actualiza o user, se não existir, insere um novo
        // DB::table('users')->updateOrInsert(
        // [
        //     'email'=>'sara5@gmail.com',
        // ],
        // [
        //     'name'=> 'Bárbara',
        //     'password'=>'1234',
        //     'updated_at' => now(),
        // ]);

        //apagar o user pelo id
        // DB::table('users')
        // ->where('id', 7)
        // ->delete();

        return response()->json('query ok!');
    }

    public function showTasks() {
        // Array de tarefas (dados estáticos)
        $tasks = [
            ['name' => 'Rita', 'task' => 'estudar laravel'],
            ['name' => 'Igor', 'task' => 'estudar Sql'],
        ];

        // Tasks vindas da base de dados com JOIN aos users
        $tasksFromDB = DB::table('tasks')
            ->join('users', 'tasks.user_id', '=', 'users.id')
            ->select('tasks.*', 'users.name as user_name')
            ->get();

        return view('utils.tasks', compact('tasks', 'tasksFromDB'));
    }

    private function getUser() {
        // query á base de dados para buscar o user
       // $users = ['Ivan', 'Maria', 'João'];
       $users = [
        ['id' => 1, 'name' => 'Rita', 'phone' => '915555555'],
        ['id' => 2, 'name' => 'Pedro', 'phone' => '916666666'],
        ['id' => 3, 'name' => 'Ana', 'phone' => '917777777'],
        ['id' => 4, 'name' => 'Luís', 'phone' => '918888888'],
        ['id' => 5, 'name' => 'Sofia', 'phone' => '919999999']
       ];
        return $users;
    }

    private function getCesaeInfo() {
        $cesaeInfo = [
            'name' => 'CESAE',
            'address' => 'Rua Ciriaco 186, 4150-212 Porto',
            'email' => 'cesae@cesae.pt'
        ];
        return $cesaeInfo;
    }

    private function getUsersFromDB(){
        //query real á base de dados
        //carrega os users da base de dados
        $users = DB::table('users')->get();
        //dd($users); //para ver os dados carregados
        return $users;
    }
}

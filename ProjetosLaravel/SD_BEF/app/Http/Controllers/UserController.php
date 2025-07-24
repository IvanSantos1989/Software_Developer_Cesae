<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class UserController extends Controller
{

    //função que carrega a view onde no futuro teremos um form para adicionar users
    public function createUser(){
        return view('users.add_user');
    }

    public function allUsers(){

        //simula ir à base de dados carregar todos os users
        $users = $this->getUsers();

        //ir de forma real à base de dados
        $usersFromDB = $this->getUsersFromDB();

        $courseResp = User::where('id', 5)
                        ->select('name', 'email')
                        ->first();

        //dd($courseResp->name);


        //carrega a view users.all_users com os dados de $users e $usersFromDB
        return view('users.all_users', compact(
            'users',
            'usersFromDB',
            'courseResp'));
    }

    public function testSqlQueries(){

        //query de insert. no futuro, os dados a inserir vêm do formulário (resquest)
        // DB::table('users')->insert([
        //     'name'=> 'Sara',
        //     'email'=>'sara5@gmail.com',
        //     'password'=>'1234'
        // ]);

        //query de update. no futuro, os dados a actualizar vêm do formulário (resquest)
        // DB::table('users')
        // ->where('id', 4)
        // ->update([
        //     'name' => 'Rita',
        //     'address'=> 'Rua da Rita',
        //     'updated_at' => now()
        // ]);


        //Update or insert

        // DB::table('users')->updateOrInsert(
        // [
        //     'email'=>'sara90@gmail.com',
        // ],
        // [
        //     'name'=> 'Bárbara',
        //     'password'=>'1234',
        //     'updated_at' => now(),
        // ]);

        //apagar o user com id 3
        // DB::table('users')
        // ->where('id',3)
        // ->delete();

        return response()->json('query ok!');
    }

    private function getUsers(){

        //simula ir à base de dados carregar todos os users
        $users = [
            ['id' => 1, 'name'=> 'Rita', 'phone'=> '915555555'],
            ['id' => 2, 'name'=> 'Rui', 'phone'=> '915555555'],
            ['id' => 3, 'name'=> 'Patrícia', 'phone'=> '915555555'],
        ];

        return $users;
    }

    private function getUsersFromDB(){
        //query real que vai à base de dados buscar todos os users
        $users = User::get();
        //->where('password', '!=', '1234')

        //dd($users);

        return $users;
    }
}

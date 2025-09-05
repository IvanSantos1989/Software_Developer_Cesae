<?php

namespace App\Http\Controllers;

use App\Models\Task;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Storage;


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
        $search = request()->query('search') ? request()->query('search') : null;
        $usersFromDB = $this->getUsersFromDB($search);

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

    //função que retorna a view de um user (o que estámos a clicar)
    public function viewUser($id){
        $myUser = User::where('id', $id)->first();

        return view('users.show_user', compact('myUser'));
    }

    //função que apaga um user com base no id
    public function deleteUser($id){
        Task::where('user_id', $id)->delete(); //apaga as tasks do user

        User::where('id', $id)->delete();

        return back();
    }

    public function storeUser(Request $request){

        //dd($request->all());

        //validação dos dados do formulário
        $request->validate([
        'name' => 'string|max:50|required',
        'email' => 'required|unique:users|email'
    ]);

    User::insert([
        'name' => $request->name,
        'email' => $request->email,
        'password' => Hash::make($request->password),
    ]);

    return redirect()->route('users.all')->with('message', 'User added successfully!');
}

    public function updateUser(Request $request){
        //dd($request->all());

        $request->validate([
            'name' => 'required',
            'photo' => 'image'
        ]);

        $photoPath = null;

        if($request->hasFile('photo')) {
            $photoPath = Storage::putFile('documents',
            $request->photo);
        }

        User::where('id', $request->id)
            ->update([
                'photo' => $photoPath,
                'name' => $request->name,
                'nif' => $request->nif,
                'address' => $request->address,
            ]);

            return redirect()->route('users.all')->with('message', 'User updated successfully!');
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

    private function getUsersFromDB($search){
        //query real que vai à base de dados buscar todos os users
        //$users = User::get();
        $query = DB::table('users');

        if($search) {
            $query->where('name', 'like', "%{$search}%")
                  ->orwhere('email', $search);
        }

        $users = $query->get();

        //->where('password', '!=', '1234')

        //dd($users);

        return $users;
    }
}

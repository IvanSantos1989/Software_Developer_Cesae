<?php

namespace App\Http\Controllers;

use App\Models\Task;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class TaskController extends Controller
{
    public function allTasks(){

        $tasks = $this->getAllTasks();

        return view('tasks.all_tasks', compact('tasks'));
    }

   //função que retorna a view de uma task (o que estámos a clicar)
    public function viewTask($id){
        $myTask = Task::join('users', 'users.id', '=', 'tasks.user_id')
            ->select('tasks.*', 'users.name as username')
            ->where('tasks.id', $id)
            ->first();

            $users = DB::table('users')->get();

        return view('tasks.show_task', compact('myTask', 'users'));
    }

    //função que atualiza uma task com base no id
    public function updateTask(Request $request){
        //dd($request->all());

        $request->validate([
            'name' => 'required',
            'user_id' => 'required',
        ]);

        Task::where('id', $request->id)
            ->update([
                'name' => $request->name,
                'description' => $request->description,
                'user_id' => $request->user_id,
                'updated_at' => now()
            ]);

        return redirect()->route('tasks.all')->with('message', 'Task updated successfully!');
    }

    //função que apaga uma task com base no id
    public function deleteTask($id){
        Task::where('id', $id)->delete();

        return back();
    }

    //função que carrega a view para adicionar uma task
    public function createTask(){
        $users = DB::table('users')->select('id', 'name')->get();

        return view('tasks.add_task', compact('users'));
    }

    //função que guarda uma task na base de dados
    public function storeTask(Request $request){
        $request->validate([
            'name' => 'required|string|max:50',
            'description' => 'required|string',
            'user_id' => 'required|exists:users,id',
        ]);
        Task::insert([
            'name' => $request->name,
            'description' => $request->description,
            'user_id' => $request->user_id,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        return redirect()->route('tasks.all')->with('message', 'Task added successfully!');
    }

    private function getAllTasks(){
        $tasks = Task::join('users', 'users.id', '=', 'tasks.user_id')
        ->select('tasks.*', 'users.name as username')
        ->get();

        return $tasks;
    }
}

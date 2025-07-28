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

        return view('tasks.show_task', compact('myTask'));
    }

    //função que apaga uma task com base no id
    public function deleteTask($id){
        Task::where('id', $id)->delete();

        return back();
    }



    private function getAllTasks(){
        $tasks = Task::join('users', 'users.id', '=', 'tasks.user_id')
        ->select('tasks.*', 'users.name as username')
        ->get();

        return $tasks;
    }
}

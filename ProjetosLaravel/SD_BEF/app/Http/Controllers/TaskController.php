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

    private function getAllTasks(){
        $tasks = Task::join('users', 'users.id', '=', 'tasks.user_id')
        ->select('tasks.*', 'users.name as username')
        ->get();

        return $tasks;
    }
}

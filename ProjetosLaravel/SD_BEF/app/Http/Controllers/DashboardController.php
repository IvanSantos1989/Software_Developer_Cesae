<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class DashboardController extends Controller
{
    /**
     * Função que retorna a view da Home do Dashboard (Backoffice)
     */
    public function index()
    {
        return view('dashboard.dashboard');
    }
}

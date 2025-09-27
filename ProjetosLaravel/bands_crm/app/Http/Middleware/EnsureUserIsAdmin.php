<?php

namespace App\Http\Middleware;

use Closure;

class EnsureUserIsAdmin
{
    public function handle($request, Closure $next)
    {
        if (!auth()->check() || auth()->user()->role !== 'admin') {
            abort(403, 'Acesso negado.');
        }
        return $next($request);
    }
}
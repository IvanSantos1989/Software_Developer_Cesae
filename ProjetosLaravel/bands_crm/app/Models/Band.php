<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class Band extends Model
{
    use HasFactory;

    protected $fillable = ['name', 'photo_path'];

    public function albums()
    {
        return $this->hasMany(Album::class);
    }
}
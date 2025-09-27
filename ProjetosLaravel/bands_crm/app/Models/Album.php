<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class Album extends Model
{
    use HasFactory;

    protected $fillable = ['band_id', 'name', 'image_path', 'release_date'];

    public function band()
    {
        return $this->belongsTo(Band::class);
    }

    protected $casts = [
    'release_date' => 'date', // <- adiciona isto
];
}
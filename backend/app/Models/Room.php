<?php


namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Room extends Model {
    public $timestamps = false;
    protected $fillable = [
        'number', 'name', 'subname', 'description', 'numperson', 'price', 'size', 'starating', 'urlimg1'
    ];
    protected $table="rooms";
}

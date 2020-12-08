<?php


namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Room extends Model {
    public $timestamps = false;
    protected $fillable = [
        'number', 'name', 'subname', 'description', 'numperson', 'price', 'size', 'starating', 'avaliable'
        , 'urlimg1', 'urlimg2', 'urlimg3', 'urlimg4'
    ];
    protected $table="rooms";
}

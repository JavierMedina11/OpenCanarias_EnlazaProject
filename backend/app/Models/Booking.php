<?php


namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Booking extends Model {
    public $timestamps = false;
    protected $fillable = [
        'check_in', 'check_out', 'diet', 'id_user', 'id_room'
    ];
    protected $table="booking";
}

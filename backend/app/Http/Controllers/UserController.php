<?php


namespace App\Http\Controllers;


use App\User;
use Illuminate\Support\Facades\Auth;

class UserController extends Controller{

    public function allUsers()
    {
        return response()->json(['users' => User::all()], 200);
    }

    public function singleUser($id){
        return User::findOrFail($id);
    }
}

<?php


namespace App\Http\Controllers;


use App\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

class UserController extends Controller{

    public function allUsers(){
        return User::all();
    }

    public function singleUser($id){
        return User::findOrFail($id);
    }

    public function updateUser(Request $request){
        $user = User::where('id', $request->id)->first();
        $user->name = $request->name;
        $user->email = $request->email;
        $plainPassword = $request->password;
        $user->password = app('hash')->make($plainPassword);
        $user->save();
        return "Post has been updated!";
    }

    public function delete($id){
        User::destroy($id);
        return response()->json([
            'res' => true,
            'message' => 'Registro ELIMINADO de la vida correctamente'
        ]);
    }
}

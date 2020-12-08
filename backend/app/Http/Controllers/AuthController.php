<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use  App\User;
use Illuminate\Support\Facades\Auth;

class AuthController extends Controller
{
    /**
     * Store a new user.
     *
     * @param  Request  $request
     * @return Response
     */
    public function register(Request $request)
    {
        try {

            $user = new User;
            $user->name = $request->input('name');
            $user->email = $request->input('email');
            $plainPassword = $request->input('password');
            $user->password = app('hash')->make($plainPassword);

            $user->save();

            //return successful response
            return response()->json(['user' => $user, 'message' => 'CREATED'], 201);

        } catch (\Exception $e) {
            //return error message
            return response()->json(['message' => 'User Registration Failed!'], 409);
        }

    }

    public function login(Request $request){
        $credentials = $request->only(['email', 'password']);

        if ($token = Auth::attempt($credentials)) {
            //return response()->json(['message' => 'Unauthorized'], 401);
            $user = Auth::guard('api')->user();
            $success = true;
            return compact('success', 'user', 'token');
        }
        else{
            $success = false;
            $message = 'Invalid credentials';
            return compact('success', 'message');
        }
    }

    public function logout(Request $request){
        Auth::guard('api')->logout();
        $success = true;
        return compact('success');
    }

    //Add this method to the Controller class
    protected function respondWithToken($token)
    {
        return response()->json([
            'token' => $token,
            'token_type' => 'bearer',
            'expires_in' => Auth::factory()->getTTL() * 60
        ], 200);
    }


}

<?php


namespace App\Http\Controllers;


use App\Models\Booking;
use Illuminate\Http\Request;

class BookingController{
    //GETTER DE TODA LA VIDA
    public function index(Request $request){
        return Booking::all();
    }

    //GETTER DE UN SOLO ELEMENTO
    public function show($id){
        return Booking::findOrFail($id);
    }

    public function showReserv($id_user){
        return Booking::all()->where('id_user', $id_user);;
    }

    //POST/*
    public function createPost(Request $request){
        $room = new Booking();
        $room->check_in = $request->check_in;
        $room->check_out = $request->check_out;
        $room->diet = $request->diet;
        $room->id_user = $request->id_user;
        $room->id_room = $request->id_room;
        $room->save();
        return "Post has been created!";
    }


    //PUT
    public function updatePost(Request $request){
        $room = Booking::where('id', $request->id)->first();
        $room->check_in = $request->check_in;
        $room->check_out = $request->check_out;
        $room->diet = $request->diet;
        $room->id_user = $request->id_user;
        $room->id_room = $request->id_room;
        $room->save();
        return "Post has been updated!";
    }

    //DELETE
    public function delete($id){
        Booking::destroy($id);
        return response()->json([
            'res' => true,
            'message' => 'Registro ELIMINADO de la vida correctamente'
        ]);
    }

}

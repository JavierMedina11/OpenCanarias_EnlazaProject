<?php


namespace App\Http\Controllers;


use App\Models\Room;
use Illuminate\Http\Request;

class RoomController extends Controller {

    //GETTER DE TODA LA VIDA
    public function index(Request $request){
        return Room::all();
    }

    //GETTER DE UN SOLO ELEMENTO
    public function show($id){
        return Room::findOrFail($id);
    }

    //POST/*
    public function createPost(Request $request){
        $room = new Room();
        $room->number = $request->number;
        $room->description = $request->description;
        $room->numPerson = $request->numPerson;
        $room->size = $request->size;
        $room->avaliable = $request->avaliable;
        $room->save();
        return "Post has been created!";
    }


    //PUT
    public function updatePost(Request $request){
        $room = Room::where('id', $request->id)->first();
        $room->number = $request->number;
        $room->description = $request->description;
        $room->numPerson = $request->numPerson;
        $room->size = $request->size;
        $room->avaliable = $request->avaliable;
        $room->save();
        return "Post has been updated!";
    }

    //DELETE
    public function delete($id){
        Room::destroy($id);
        return response()->json([
            'res' => true,
            'message' => 'Registro ELIMINADO de la vida correctamente'
        ]);
    }
}

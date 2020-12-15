<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateBookingTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('booking', function (Blueprint $table) {
            $table->id();
            $table->string('check_in');
            $table->string('check_out');
            $table->String('diet');
            $table->unsignedBigInteger("id_user");
            $table->foreign("id_user")->references('id')->on('users');
            $table->unsignedBigInteger("id_room");
            $table->foreign("id_room")->references('id')->on('rooms');

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('booking');
    }
}

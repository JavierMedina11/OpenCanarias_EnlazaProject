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
            $table->date('check_in');
            $table->integer('nights');
            $table->integer('diet');
            $table->unsignedBigInteger("id_user");
            $table->foreign("id_user")->references('id')->on('users');
            $table->unsignedBigInteger("id_room");
            $table->foreign("id_user")->references('id')->on('rooms');

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

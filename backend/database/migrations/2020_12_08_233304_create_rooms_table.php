<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateRoomsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('rooms', function (Blueprint $table) {
            $table->id();
            $table->integer('number');
            $table->string('name');
            $table->string('subname');
            $table->string('description');
            $table->integer('numperson');
            $table->integer('size');
            $table->integer('price');
            $table->float('starating');
            $table->boolean('avaliable');
            $table->string('urlimg1');
            $table->string('urlimg2');
            $table->string('urlimg3');
            $table->string('urlimg4');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {

    }
}

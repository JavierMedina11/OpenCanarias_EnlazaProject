<?php

/** @var \Laravel\Lumen\Routing\Router $router */

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', function () use ($router) {
    return $router->app->version();
});

// API route group
$router->group(['prefix' => 'api'], function () use ($router) {
    // Matches "/api/register
    $router->post('register', 'AuthController@register');
    // Matches "/api/login
    $router->post('login', 'AuthController@login');
    // Matches "/api/logout
    $router->post('logout', 'AuthController@logout');
    // Matches "/api/users
    $router->get('users', 'UserController@allUsers');
    // Matches "/api/users/{id}
    $router->get('users/{id}', 'UserController@singleUser');
    // Matches "/api/rooms
    $router->get('rooms', ['as' => 'room', 'uses' => 'RoomController@index']);
    // Matches "/api/rooms/{id}
    $router->get('rooms/{id}', ['as' => 'room.show', 'uses' => 'RoomController@show']);
});

package com.opencanarias.frontend.io

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.opencanarias.frontend.io.response.LoginResponse
import com.opencanarias.frontend.models.Booking
import com.opencanarias.frontend.models.Room
import com.opencanarias.frontend.models.User
import org.json.JSONArray
import org.json.JSONObject

class ServiceImpl: IVolleyService {

    override fun getAll(context: Context, completionHandler: (response: ArrayList<Room>?) -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "rooms"
        val arrayRequest = JsonArrayRequest(Request.Method.GET, path, null,
            { response ->
                var rooms: ArrayList<Room> = ArrayList()
                for (i in 0 until response.length()) {
                    val bicycle = response.getJSONObject(i)
                    val id = bicycle.getInt("id")
                    val number = bicycle.getInt("number")
                    val name = bicycle.getString("name")
                    val subname = bicycle.getString("subname")
                    val description = bicycle.getString("description")
                    val numperson = bicycle.getInt("numperson")
                    val size = bicycle.getInt("size")
                    val price = bicycle.getInt("price")
                    val starating = bicycle.getDouble("starating")
                    val avaliable = bicycle.getInt("avaliable")
                    val urlimg1 = bicycle.getString("urlimg1")
                    val urlimg2 = bicycle.getString("urlimg2")
                    val urlimg3 = bicycle.getString("urlimg3")
                    val urlimg4 = bicycle.getString("urlimg4")
                    rooms.add(Room(id, number, name, subname, description, numperson, size, price,
                        starating.toFloat(), avaliable, urlimg1, urlimg2, urlimg3, urlimg4))
                }
                completionHandler(rooms)
            },
            { error ->
                completionHandler(ArrayList<Room>())
            })
        ServiceSingleton.getInstance(context).addToRequestQueue(arrayRequest)
    }

    override fun getBookings(context: Context, completionHandler: (response: ArrayList<Booking>?) -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "booking"
        val arrayRequest = JsonArrayRequest(Request.Method.GET, path, null,
                { response ->
                    var bookings: ArrayList<Booking> = ArrayList()
                    for (i in 0 until response.length()) {
                        val booking = response.getJSONObject(i)
                        val id = booking.getInt("id")
                        val check_in = booking.getString("check_in")
                        val check_out = booking.getString("check_out")
                        val diet = booking.getString("diet")
                        val id_user = booking.getInt("id_user")
                        val id_room = booking.getInt("id_room")
                        bookings.add(Booking(id, check_in, check_out, diet, id_user, id_room))
                    }
                    completionHandler(bookings)
                },
                { error ->
                    completionHandler(ArrayList<Booking>())
                })
        ServiceSingleton.getInstance(context).addToRequestQueue(arrayRequest)
    }

    override fun getBooking(context: Context, userId: Int, completionHandler: (response: ArrayList<Booking>?) -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "usereserve/" + userId
        val arrayRequest = JsonArrayRequest(Request.Method.GET, path, null,
                { response ->
                    var bookings: ArrayList<Booking> = ArrayList()
                    val bookingArray: JSONArray = response.getJSONArray(1)
                    for (i in 0 until bookingArray.length()) {
                        val booking = response.getJSONObject(i)
                        val id = booking.getInt("id")
                        val check_in = booking.getString("check_in")
                        val check_out = booking.getString("check_out")
                        val diet = booking.getString("diet")
                        val id_user = booking.getInt("id_user")
                        val id_room = booking.getInt("id_room")
                        bookings.add(Booking(id, check_in, check_out, diet, id_user, id_room))
                    }
                    completionHandler(bookings)
                },
                { error ->
                    completionHandler(ArrayList<Booking>())
                })
        ServiceSingleton.getInstance(context).addToRequestQueue(arrayRequest)
    }

    override fun getById(context: Context, roomId: Int, completionHandler: (response: Room?) -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "rooms/" + roomId
        val objectRequest = JsonObjectRequest(Request.Method.GET, path, null,
            { response ->
                if(response == null) completionHandler(null)
                val id = response.getInt("id")
                val number = response.getInt("number")
                val name = response.getString("name")
                val subname = response.getString("subname")
                val description = response.getString("description")
                val numperson = response.getInt("numperson")
                val size = response.getInt("size")
                val price = response.getInt("price")
                val starating = response.getDouble("starating")
                val avaliable = response.getInt("avaliable")
                val urlimg1 = response.getString("urlimg1")
                val urlimg2 = response.getString("urlimg2")
                val urlimg3 = response.getString("urlimg3")
                val urlimg4 = response.getString("urlimg4")

                val bicycle = Room(id, number, name, subname, description, numperson, size, price,
                    starating.toFloat(), avaliable, urlimg1, urlimg2, urlimg3, urlimg4)
                completionHandler(bicycle)
            },
            { error ->
                completionHandler(null)
            })
        ServiceSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun registerUser(context: Context, user: User, completionHandler: () -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "register"
        val bicycleJson: JSONObject = JSONObject()
        bicycleJson.put("id", user.id.toString())
        bicycleJson.put("name", user.name)
        bicycleJson.put("email", user.email)
        bicycleJson.put("password", user.password)

        val objectRequest = JsonObjectRequest(Request.Method.POST, path, bicycleJson,
            { response -> completionHandler() },
            { error -> completionHandler() })
        ServiceSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun getByIdUser(context: Context, userId: Int, completionHandler: (response: User?) -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "users/" + userId
        val objectRequest = JsonObjectRequest(Request.Method.GET, path, null,
            { response ->
                if(response == null) completionHandler(null)
                val id = response.getInt("id")
                val name = response.getString("name")
                val email = response.getString("email")
                val password = response.getString("password")

                val user = User(id, name, email, password)
                completionHandler(user)
            },
            { error ->
                completionHandler(null)
            })
        ServiceSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun generateReserve(context: Context, booking: Booking, completionHandler: () -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "booking"
        val bookingJSON: JSONObject = JSONObject()
        bookingJSON.put("id", booking.id.toString())
        bookingJSON.put("check_in", booking.check_in)
        bookingJSON.put("check_out", booking.check_out)
        bookingJSON.put("diet", booking.diet)
        bookingJSON.put("id_user", booking.id_user)
        bookingJSON.put("id_room", booking.id_room)

        val objectRequest = JsonObjectRequest(Request.Method.POST, path, bookingJSON,
                { response -> completionHandler() },
                { error -> completionHandler() })
        ServiceSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun deleteById(context: Context, roomId: Int, completionHandler: () -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "booking/" + roomId
        val objectRequest = JsonObjectRequest(Request.Method.DELETE, path, null,
                { response ->
                    Log.v("Hola caracola", "se borró")
                    completionHandler()
                },
                { error ->
                    Log.v("Hola caracola", "dió error")
                    completionHandler()
                })
        ServiceSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun updateReserve(context: Context, booking: Booking, completionHandler: () -> Unit) {
        val path = ServiceSingleton.getInstance(context).baseUrl + "booking/" + booking.id
            val bookingJSON: JSONObject = JSONObject()
                bookingJSON.put("id", booking.id.toString())
                bookingJSON.put("check_in", booking.check_in)
                bookingJSON.put("check_out", booking.check_out)
                bookingJSON.put("diet", booking.diet)
                bookingJSON.put("id_user", booking.id_user)
                bookingJSON.put("id_room", booking.id_room)

            val objectRequest = JsonObjectRequest(Request.Method.PUT, path, bookingJSON,
                    { response ->
                        completionHandler()
                    },
                    { error ->
                        completionHandler()
                    })
        ServiceSingleton.getInstance(context).addToRequestQueue(objectRequest)
        }
}
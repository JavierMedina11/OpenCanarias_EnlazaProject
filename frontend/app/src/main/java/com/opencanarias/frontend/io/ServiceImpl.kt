package com.opencanarias.frontend.io

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.opencanarias.frontend.io.response.LoginResponse
import com.opencanarias.frontend.models.Room
import com.opencanarias.frontend.models.User
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
        val path = ServiceSingleton.getInstance(context).baseUrl + "/register"
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
}
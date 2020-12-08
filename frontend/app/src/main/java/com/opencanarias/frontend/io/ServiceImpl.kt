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
        val path = ServiceSingleton.getInstance(context).baseUrl + "/api/rooms"
        val arrayRequest = JsonArrayRequest(Request.Method.GET, path, null,
            { response ->
                var rooms: ArrayList<Room> = ArrayList()
                for (i in 0 until response.length()) {
                    val bicycle = response.getJSONObject(i)
                    val id = bicycle.getInt("id")
                    val model = bicycle.getString("model")
                    val brand = bicycle.getString("brand")
                    rooms.add(Room(id, brand, model))
                }
                completionHandler(bicycles)
            },
            { error ->
                completionHandler(ArrayList<Bicycle>())
            })
        BicycleSingleton.getInstance(context).addToRequestQueue(arrayRequest)
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
}
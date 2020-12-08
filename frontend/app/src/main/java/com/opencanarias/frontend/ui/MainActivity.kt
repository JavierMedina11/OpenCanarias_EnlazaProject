package com.opencanarias.frontend.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.IRetrofitService
import com.opencanarias.frontend.io.ServiceImpl
import com.opencanarias.frontend.models.Room
import com.retrofitP.loginimplementation.util.PreferenceHelper
import com.retrofitP.loginimplementation.util.PreferenceHelper.get
import com.retrofitP.loginimplementation.util.PreferenceHelper.set
import com.retrofitP.loginimplementation.util.toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val retrofitService: IRetrofitService by lazy{
        IRetrofitService.create()
    }

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    private lateinit var rooms: ArrayList<Room>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RoomAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        val listRooms: ArrayList<Room> = ArrayList<Room>(10);
            listRooms.add(Room("France", "Eiffel Tower","@drawable/france.jpg", 3.2f))
            listRooms.add(Room("Spain", "Sagrada Familia","@drawable/france.jpg", 5f))
            listRooms.add(Room("Italy", "Coliseo Romano","@drawable/france.jpg", 4.78f))
        */
        rooms = ArrayList<Room>()

        viewManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        viewAdapter = RoomAdapter(rooms, this)
        recyclerView = findViewById<RecyclerView>(R.id.locationViewPager)
        // use a linear layout manager
        recyclerView.layoutManager = viewManager
        // specify an viewAdapter (see also next example)
        recyclerView.adapter = viewAdapter

        getAllRooms()

        buttonLogout.setOnClickListener(){
            performLogout()
        }
    }

    private fun getAllRooms() {
        val roomServiceImpl = ServiceImpl()
        roomServiceImpl.getAll(this) { response ->
            run {
                if (response != null) {
                    viewAdapter.roomList = response
                }
                viewAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun performLogout(){
        val jwt = preferences["token", ""]
        val call = retrofitService.postLogout("Bearer $jwt")
        call.enqueue(object: Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                clearSessionPreferences()
                intent()
            }
            override fun onFailure(call: Call<Void>, t: Throwable) {
                toast(t.localizedMessage)
            }
        })
    }

    private fun clearSessionPreferences(){
        preferences["token"] = "";
    }

    private fun intent(){
        val intent= Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
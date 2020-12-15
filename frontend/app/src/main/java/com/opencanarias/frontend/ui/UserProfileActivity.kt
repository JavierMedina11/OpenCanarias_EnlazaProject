package com.opencanarias.frontend.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.ServiceImpl
import com.opencanarias.frontend.models.Booking
import com.opencanarias.frontend.models.Room
import com.retrofitP.loginimplementation.util.PreferenceHelper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user_profile.*

import com.retrofitP.loginimplementation.util.PreferenceHelper.get
import com.retrofitP.loginimplementation.util.PreferenceHelper.set


class UserProfileActivity : AppCompatActivity() {

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    private lateinit var bookings: ArrayList<Booking>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: UserAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val userId = preferences.getInt("userDNI", 1)
        val avatar = preferences.getString("avatar", "aaa").toString()
        val avatarGirl = "avatarProfile.setBackgroundResource(R.drawable.defaultgirl);"
        val avatarBoy = "avatarProfile.setBackgroundResource(R.drawable.profile_default);"

        getUser(userId)

        bookings = ArrayList<Booking>()

        viewManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        viewAdapter = UserAdapter(bookings, this)
        recyclerView = findViewById<RecyclerView>(R.id.locationViewBookings)
        // use a linear layout manager
        recyclerView.layoutManager = viewManager
        // specify an viewAdapter (see also next example)
        recyclerView.adapter = viewAdapter

        if(avatar == avatarBoy){
            avatarProfile.setBackgroundResource(R.drawable.profile_default)
        }else if(avatar == avatarGirl){
            avatarProfile.setBackgroundResource(R.drawable.defaultgirl)
        }

        val preferences = PreferenceHelper.defaultPrefs(this)
        toggleButton.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked) {
                avatarProfile.setBackgroundResource(R.drawable.defaultgirl)
                preferences["avatar"] = avatarGirl;
            }
            else
                avatarProfile.setBackgroundResource(R.drawable.profile_default)
                preferences["avatar"] = avatarBoy;
        }

        backButtonNeu.setOnClickListener {
            goToMainActivity()
        }

        deleteButton.setOnClickListener {
            val bicycleServiceImpl = ServiceImpl()
            bicycleServiceImpl.deleteByIdUser(this, userId) { ->
                run {
                    preferences["token"] = "";
                    preferences["userDNI"] = "";
                    val intent = Intent(this, HomeActivity::class.java)
                    this.startActivity(intent)
                    finish()
                }
            }
        }

        updateButtonPrueba.setOnClickListener {
            goToUpdateActivity()
        }

        getBookings()
        //getBooking(userId)
    }

    private fun getBookings() {
        val roomServiceImpl = ServiceImpl()
        roomServiceImpl.getBookings(this) { response ->
            run {
                if (response != null) {
                    viewAdapter.bookingList = response
                }
                viewAdapter.notifyDataSetChanged()
            }
        }
    }
/*
    private fun getBooking(userId: Int) {
        val roomServiceImpl = ServiceImpl()
        roomServiceImpl.getBooking(this, userId) { response ->
            run {
                if (response != null) {
                    viewAdapter.bookingList = response
                }
                viewAdapter.notifyDataSetChanged()
            }
        }
    }
*/
    private fun getUser(userId: Int) {
        val serviceImpl = ServiceImpl()
        serviceImpl.getByIdUser(this, userId) { response ->
            run {
                val roomName: TextView = findViewById(R.id.namePasteUser)
                roomName.setText(response?.name ?: "")
            }
        }
    }

    private fun goToMainActivity(){
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun goToUpdateActivity() {
        val intent= Intent(this, UpdateUser::class.java)
        startActivity(intent)
    }
}
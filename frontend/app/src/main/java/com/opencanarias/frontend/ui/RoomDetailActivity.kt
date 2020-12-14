package com.opencanarias.frontend.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.ServiceImpl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_room_detail.*



class RoomDetailActivity : AppCompatActivity() {
    private lateinit var state: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        state = this.intent.getStringExtra("state").toString()

        val roomId = this.intent.getIntExtra("roomId", 1)

        if(state == "Showing") getRoom(roomId)

        roomBook.setOnClickListener {
            goToReservationActivity(roomId)
        }
    }

    private fun goToReservationActivity(roomId: Int) {
        val intent= Intent(this, ReservationActivity::class.java)
        intent.putExtra("roomId", roomId)
        intent.putExtra("state", "Create")
        startActivity(intent)
    }

    private fun getRoom(bicycleId: Int) {
        val bicycleServiceImpl = ServiceImpl()
        bicycleServiceImpl.getById(this, bicycleId) { response ->
            run {
                val url = "http://192.168.56.1:8000/img/"
                val roomSubName: TextView = findViewById(R.id.roomSubName)
                val roomName: TextView = findViewById(R.id.roomName)
                val roomDescription: TextView = findViewById(R.id.roomDescription)
                val roomImg: ImageView = findViewById(R.id.roomImage)
                val roomSize: TextView = findViewById(R.id.roomSize)
                val roomPrice: TextView = findViewById(R.id.roomPrice)

                val imageUrl = url + response?.urlimg1 + ".png" ?: ""
                Picasso.with(this).load(imageUrl).into(roomImg);

                roomSubName.setText(response?.subname ?: "")
                roomName.setText(response?.name ?: "")
                roomDescription.setText(response?.description ?: "")
                roomPrice.setText(response?.price.toString() + "$" ?: "")
                roomSize.setText(response?.size.toString() + " m2" ?: "")
            }
        }
    }

}
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
                val roomImg1: ImageView = findViewById(R.id.roomImg1)
                val roomImg2: ImageView = findViewById(R.id.roomImg2)
                val roomImg3: ImageView = findViewById(R.id.roomImg3)
                val roomPrice: TextView = findViewById(R.id.roomPrice)

                val imageUrl = url + response?.urlimg1 + ".png" ?: ""
                /*val imageUrl2 = url + response?.urlimg2 + ".png" ?: ""
                val imageUrl3 = url + response?.urlimg3 + ".png" ?: ""
                val imageUrl4 = url + response?.urlimg4 + ".png" ?: ""*/
                Picasso.with(this).load(imageUrl).into(roomImg);
                /*Picasso.with(this).load(imageUrl2).into(roomImg1);
                Picasso.with(this).load(imageUrl3).into(roomImg2);
                Picasso.with(this).load(imageUrl4).into(roomImg3);*/

                roomSubName.setText(response?.subname ?: "")
                roomName.setText(response?.name ?: "")
                roomDescription.setText(response?.description ?: "")
                roomPrice.setText(response?.price.toString() + "$" ?: "")
            }
        }
    }

}
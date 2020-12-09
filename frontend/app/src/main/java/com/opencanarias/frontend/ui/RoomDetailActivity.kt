package com.opencanarias.frontend.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.ServiceImpl
import com.opencanarias.frontend.io.ServiceSingleton
import com.squareup.picasso.Picasso

class RoomDetailActivity : AppCompatActivity() {
    private lateinit var state: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        state = this.intent.getStringExtra("state").toString()

        val roomId = this.intent.getIntExtra("roomId", 1)

        if(state == "Showing") getRoom(roomId)
    }

    private fun getRoom(bicycleId: Int) {
        val bicycleServiceImpl = ServiceImpl()
        bicycleServiceImpl.getById(this, bicycleId) { response ->
            run {

                val roomSubName: TextView = findViewById(R.id.roomSubName)
                val roomName: TextView = findViewById(R.id.roomName)
                val roomDescription: TextView = findViewById(R.id.roomDescription)
                val roomImg1: ImageView = findViewById(R.id.roomImg1)
                val roomImg2: ImageView = findViewById(R.id.roomImg2)
                val roomImg3: ImageView = findViewById(R.id.roomImg3)
                val roomPrice: TextView = findViewById(R.id.roomPrice)

                roomSubName.setText(response?.name ?: "")
                roomName.setText(response?.subname ?: "")
                roomDescription.setText(response?.description ?: "")
                // roomImg1.setText(response?.urlimg1 ?: "")
                // roomImg2.setText(response?.model ?: "")
                // roomImg3.setText(response?.brand ?: "")
                roomPrice.setText(response?.price.toString() ?: "")

                val url = ServiceSingleton.getInstance(this).baseUrl + "/img/bicycle-"
                val imageUrl = url + (response?.id.toString() ?: "0" ) + ".jpg"
                //Picasso.with(this).load(imageUrl).into(img);
            }
        }
    }

}
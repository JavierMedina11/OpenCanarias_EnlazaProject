package com.opencanarias.frontend.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.ServiceImpl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val userId = this.intent.getIntExtra("userIdent", 1)

        getUser(userId)

        backButton.setOnClickListener {
            goToMainActivity()
        }
    }

    private fun getUser(userId: Int) {
        val bicycleServiceImpl = ServiceImpl()
        bicycleServiceImpl.getByIdUser(this, userId) { response ->
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
}
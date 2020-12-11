package com.opencanarias.frontend.ui

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
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

        pruebaButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                avatarProfile.setBackgroundResource(R.drawable.defaultgirl)
            }
        })

        getUser(userId)

        backButtonNeu.setOnClickListener {
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
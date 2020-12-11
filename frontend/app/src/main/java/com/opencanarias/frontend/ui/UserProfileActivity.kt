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
import com.retrofitP.loginimplementation.util.PreferenceHelper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user_profile.*

import com.retrofitP.loginimplementation.util.PreferenceHelper.get


class UserProfileActivity : AppCompatActivity() {

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val userId = preferences.getInt("userDNI", 1)

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
}
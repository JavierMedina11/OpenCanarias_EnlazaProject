package com.opencanarias.frontend.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.ServiceImpl
import com.opencanarias.frontend.models.Booking
import com.opencanarias.frontend.models.User
import com.retrofitP.loginimplementation.util.PreferenceHelper
import kotlinx.android.synthetic.main.activity_update_user.*

class UpdateUser : AppCompatActivity() {

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        val userId = preferences.getInt("userDNI", 1)

        updateUserButton.setOnClickListener {
            val user = User(userId, updateName.text.toString(), updatEmail.text.toString(), updatePassword.text.toString())
            updateUser(user)
        }

    }

    private fun updateUser(user: User) {
        val userServiceImpl = ServiceImpl()
        userServiceImpl.updateUser(this, user) { ->
            run {
                val intent = Intent(this, UserProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
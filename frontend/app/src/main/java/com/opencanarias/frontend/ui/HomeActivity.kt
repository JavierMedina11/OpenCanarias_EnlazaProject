package com.opencanarias.frontend.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opencanarias.frontend.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageButton.setOnClickListener {
            goToLoginActivity()
        }
    }

    private fun goToLoginActivity(){
        val intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
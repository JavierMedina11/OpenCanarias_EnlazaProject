package com.opencanarias.frontend.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opencanarias.frontend.R
//import com.opencanarias.frontend.io.IRetrofitService
import com.opencanarias.frontend.io.ServiceImpl
import com.opencanarias.frontend.io.response.LoginResponse
import com.opencanarias.frontend.models.User
import com.retrofitP.loginimplementation.util.toast
import kotlinx.android.synthetic.main.activity_register.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
/*
    private val retrofitService: IRetrofitService by lazy{
        IRetrofitService.create()
    }
*/
    //val userId = this.intent.getIntExtra("id", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        loginGo.setOnClickListener {
            goToLoginActivity()
        }
        neumorphButtonRegister.setOnClickListener {
            performRegister()
        }
    }

    private fun performRegister(){
        val name = layout_name.toString().trim()
        val email = layout_emailR.toString().trim()
        val password = layout_passwordR.toString()
        val passwordConfirmation = layout_passwordConfirmation.toString()

        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty()){
            toast(getString(R.string.error_register_empty_fields))
            return
        }
        if(password != passwordConfirmation){
            toast(getString(R.string.error_register_paswords_do_not_match))
            return
        }
        val userId = 30;
        val user = User(userId, name, email, password)
        createUser(user)
    }

    private fun createUser(user: User) {
        val bicycleServiceImpl = ServiceImpl()
        bicycleServiceImpl.registerUser(this, user) { ->
            run {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun goToLoginActivity(){
        val intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
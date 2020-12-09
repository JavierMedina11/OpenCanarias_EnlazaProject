package com.opencanarias.frontend.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opencanarias.frontend.R
//import com.opencanarias.frontend.io.IRetrofitService
import com.opencanarias.frontend.io.response.LoginResponse
import com.retrofitP.loginimplementation.util.PreferenceHelper
import com.retrofitP.loginimplementation.util.PreferenceHelper.set
import com.retrofitP.loginimplementation.util.toast
import kotlinx.android.synthetic.main.activity_login.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

class LoginActivity : AppCompatActivity() {
/*
    private val retrofitService: IRetrofitService by lazy{
        IRetrofitService.create()
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        neumorphButton.setOnClickListener {
            goToMainActivity()
        }

        registerGo.setOnClickListener {
            goToRegisterActivity()
        }
    }
/*
    private fun performLogin(){
        val call= retrofitService.postLogin(layout_email.text.toString(), layout_password.text.toString())
        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                toast(t.localizedMessage)
            }
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse == null) {
                        toast(getString(R.string.error_login_response))
                        return
                    }
                    if (loginResponse!!.success){
                        createSessionPreference(loginResponse!!.token)
                        goToMainActivity()
                    }else
                        toast(getString(R.string.error_invalid_credentials))
                }else{
                    toast(getString(R.string.error_login_response))
                }
            }
        })
    }
*/
    private fun goToMainActivity(){
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRegisterActivity(){
        val intent= Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun createSessionPreference(token: String){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["token"] = token;
    }
}
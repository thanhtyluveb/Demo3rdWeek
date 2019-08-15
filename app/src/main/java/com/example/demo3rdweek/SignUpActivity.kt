package com.example.demo3rdweek

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_signup.*


class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            tvSignIn -> finish()
            btnBack -> finish()
            btnSignUp -> {
                val returnIntentForLogin = Intent()
                returnIntentForLogin.putExtra("UserName", editEmailSignUp.text)
                returnIntentForLogin.putExtra("PassWord", editPassWordSignUp.text)
                setResult(Activity.RESULT_OK, returnIntentForLogin)
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initView()
    }

    private fun initView() {
        tvSignIn.setOnClickListener(this)
        btnBack.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)
    }
}

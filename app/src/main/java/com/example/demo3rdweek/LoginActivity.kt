package com.example.demo3rdweek

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            btnSignIn -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            tvSignUp -> {
                val mIntent = Intent(this, SignUpActivity::class.java)
                startActivityForResult(mIntent, SIGN_UP_REQUEST_CODE)

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        btnSignIn.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)
    }

    companion object {
        const val SIGN_UP_REQUEST_CODE = 1  // The request code
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SIGN_UP_REQUEST_CODE) {
                editEmailLogin.setText(data?.getStringExtra("UserName") ?: "")
                editPassWordLogin.setText(data?.getStringExtra("PassWord") ?: "")
            }
        }
    }
}

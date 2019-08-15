package com.example.demo3rdweek

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.demo3rdweek.fragment.InBoxFragment
import com.example.demo3rdweek.fragment.TimeLifeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private val mFragmentManager: FragmentManager = supportFragmentManager
    private val mFragmentTran: FragmentTransaction = mFragmentManager.beginTransaction()
    override fun onClick(v: View?) {
        when (v) {
            btnHome -> {
                val mFragmentTran: FragmentTransaction = mFragmentManager.beginTransaction()
                mFragmentTran.replace(R.id.layoutContainer, TimeLifeFragment(), "TimeLifeFragment")
                mFragmentTran.commit()
            }
            btnMess -> {
                val mFragmentTran: FragmentTransaction = mFragmentManager.beginTransaction()
                mFragmentTran.replace(R.id.layoutContainer, InBoxFragment(), "InBoxFragment")
                mFragmentTran.commit()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mFragmentTran.add(R.id.layoutContainer, TimeLifeFragment(), "TimeLifeFragment")
        mFragmentTran.commit()
        initView()
    }

    private fun initView() {
        btnHome.setOnClickListener(this)
        btnMess.setOnClickListener(this)
    }
}

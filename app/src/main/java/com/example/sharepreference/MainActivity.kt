package com.example.sharedprefs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.sharepreference.R


class MainActivity : ComponentActivity() {
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.txt_name)
        val etPassword = findViewById<EditText>(R.id.password)
        val btnSave = findViewById<Button>(R.id.txt_luu)
        val btnDelete = findViewById<Button>(R.id.txt_xoa)
        val btnShow = findViewById<Button>(R.id.txt_hienthi)
        val tvResult = findViewById<TextView>(R.id.txtResult)

        preferenceHelper = PreferenceHelper(this)


        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val password = etPassword.text.toString()
            preferenceHelper.saveUser(name, password)
        }


        btnShow.setOnClickListener {
            val (name, password) = preferenceHelper.getUser()
            tvResult.text = "Tên: $name\nMật khẩu: $password"
        }


        btnDelete.setOnClickListener {
            preferenceHelper.clearUser()
            tvResult.text = "Dữ liệu đã bị xóa!"
        }
    }
}



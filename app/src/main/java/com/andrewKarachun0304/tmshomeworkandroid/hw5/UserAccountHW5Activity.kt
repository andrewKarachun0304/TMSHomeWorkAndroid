package com.andrewKarachun0304.tmshomeworkandroid.hw5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrewKarachun0304.tmshomeworkandroid.R
import kotlinx.android.synthetic.main.activity_user_account_h_w5.*

private const val USER_NAME_KEY = "user name"

class UserAccountHW5Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_account_h_w5)

        val text = intent.getStringExtra(USER_NAME_KEY)
        user_name_tv.text = "Welcome $text"
    }
}
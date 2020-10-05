package com.andrewKarachun0304.tmshomeworkandroid.hw5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_home_work5.*

private const val USER_NAME_KEY = "user name"

class HomeWork5Activity : AppCompatActivity() {
    private var login = false
    private var password = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work5)

        initUserNameListener()
        initUserPasswordListener()

        user_sign_up_btn.setOnClickListener {
            if (password && login) {
                successfulSignUp()
            } else {
                unsuccessfulSignUp()
            }
        }
    }

    private fun initUserNameListener() {
        user_name_et.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                user_name_tf.isErrorEnabled = true
                user_name_tf.error = "Name must be not empty"
            } else {
                login = true
                user_name_tf.error = null
            }
        }
    }

    private fun initUserPasswordListener() {
        user_password_et.addTextChangedListener {
            if (it.toString().length < 8) {
                user_password_tf.isErrorEnabled = true
                user_password_tf.error = "Password length must be at least 8 characters"
            } else {
                password = true
                user_password_tf.error = null
            }

        }
    }

    private fun createAlertDialog(title: String, message: String) =
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton("Ok") { dialog, _ ->
                dialog.cancel()
            }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun successfulSignUp() {
        createAlertDialog("Success", "${user_name_et.text} you are register")
            .setPositiveButton("Sign in") { _, _ ->
                intent = Intent(this, UserAccountHW5Activity::class.java)
                intent.putExtra(USER_NAME_KEY, user_name_et.text.toString())
                startActivity(intent)
            }
            .setIcon(getDrawable(R.drawable.login))
            .show()
    }

    private fun unsuccessfulSignUp() {
        createAlertDialog("Error", "You are'n register")
            .show()
    }
}
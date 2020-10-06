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
        user_name_et.addTextChangedListener { nameEt ->
            if (nameEt.isNullOrEmpty()) {
                login = false
                user_name_tf.error = resources.getString(R.string.name_must_be_not_empty_str)
            } else {
                login = true
                user_name_tf.error = null
            }
        }
    }

    private fun initUserPasswordListener() {
        user_password_et.addTextChangedListener { passwordEt ->
            if (passwordEt.toString().length < 8) {
                password = false
                user_password_tf.error = resources.getString(R.string.min_password_size_str)
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
            .setNegativeButton(resources.getString(R.string.ok_str)) { dialog, _ ->
                dialog.cancel()
            }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun successfulSignUp() {
        createAlertDialog(
            resources.getString(R.string.success_str),
            "${user_name_et.text} ${resources.getString(R.string.register_message_str)}"
        )
            .setPositiveButton(resources.getText(R.string.sign_in_str)) { _, _ ->
                intent = Intent(this, UserAccountHW5Activity::class.java)
                intent.putExtra(USER_NAME_KEY, user_name_et.text.toString())
                startActivity(intent)
            }
            .setIcon(getDrawable(R.drawable.login))
            .show()
    }

    private fun unsuccessfulSignUp() {
        createAlertDialog(
            resources.getString(R.string.error_str),
            resources.getString(R.string.error_message_str)
        ).show()
    }
}
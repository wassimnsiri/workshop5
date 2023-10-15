package com.example.gamerwassim

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.gamerwassim.databinding.ActivityForgetPassswrdBinding
import com.example.gamerwassim.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class ActivityForgetPassword :AppCompatActivity() {

    private lateinit var binding: ActivityForgetPassswrdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPassswrdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
            Submit()
        }
        binding.btnSendSMS.setOnClickListener {
            sendSms()
        }

    }

    private fun sendSms() {

        val emailText = binding.tiEmail.text.toString()
        val intent = Intent(this, ActivityOtpValidation::class.java)
        if (emailText.isEmpty()) {
            showSnackbar("You must enter your number!")
            return
        }
        startActivity(intent)
    }

    private fun Submit() {
        val emailText = binding.tiEmail.text.toString()
        val intent = Intent(this, ActivityOtpValidation::class.java)
        if (emailText.isEmpty()) {
            showSnackbar("You must enter your email!")
            return
        }
        startActivity(intent)
    }





    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

}
package com.example.gamerwassim

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gamerwassim.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar


class ActivityLogin : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListner()
        passwrdFocusListner()

        binding.btnCreateAccount.setOnClickListener {
            signup()
        }
        binding.btnForgotPassword.setOnClickListener {
            forgetPassword()
        }
        binding.btnGoogleLogin.setOnClickListener {
            showSnackbar("Coming soon")
        }
        binding.btnFacebookLogin.setOnClickListener {
            showSnackbar("Coming soon")
        }
    }

    private fun forgetPassword() {
        val intent = Intent(this, ActivityForgetPassword::class.java)
        startActivity(intent)
    }

    private fun signup() {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }

    private fun emailFocusListner() {
        binding.tiEmail.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.tiEmailLayout.helperText = validEmail()

            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.tiEmail.text.toString()
        if (emailText.isEmpty()) {
            return "Email field must not be empty"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "invalid Email"
        }
        return null
    }

    private fun passwrdFocusListner() {
        binding.tiPassword.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.tiPasswordLayout.helperText = validPassword()

            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.tiPassword.text.toString()
        if (passwordText.isEmpty()) {
            return "Email field must not be empty"
        }
        return null
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()

    }

}
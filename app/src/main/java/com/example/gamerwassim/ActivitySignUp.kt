package com.example.gamerwassim

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.gamerwassim.databinding.ActivitySignUpBinding

class ActivitySignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        passwordFocusListener()
        fullNameListener()
        confirmPasswordListener()
    }

    private fun emailFocusListener() {
        binding.tiEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tiEmailLayout.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.tiEmail.text.toString()
        if (emailText.isEmpty()) {
            return "Email field must not be empty"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.tiPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tiPasswordLayout.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.tiPassword.text.toString()
        if (passwordText.isEmpty()) {
            return "Password field must not be empty"
        }
        if (passwordText.length < 8) {
            return "Password must be at least 8 characters long"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Password must contain at least 1 uppercase character"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Password must contain at least 1 lowercase character"
        }
        return null
    }

    private fun fullNameListener() {
        binding.tiFullName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tiFullNameLayout.helperText = validFullName()
            }
        }
    }

    private fun validFullName(): String? {
        val fullNameText = binding.tiFullName.text.toString()
        if (fullNameText.isEmpty()) {
            return "Name field must not be empty"
        }
        if (fullNameText.length < 6) {
            return "Name must be at least 6 characters long"
        }
        return null
    }

    private fun confirmPasswordListener() {
        binding.tiConfirmPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tiConfirmPasswordLayout.helperText = confirmPasswords()
            }
        }
    }

    private fun confirmPasswords(): String? {
        val passwordText = binding.tiPassword.text.toString()
        val confirmPasswordText = binding.tiConfirmPassword.text.toString()
        if (confirmPasswordText.isEmpty()) {
            return "Confirmation field must not be empty"
        }
        if (passwordText != confirmPasswordText) {
            return "Passwords do not match"
        }
        return null
    }
}

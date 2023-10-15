package com.example.gamerwassim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamerwassim.databinding.ActivityResetPasswordBinding


class ActivityResetPassword :AppCompatActivity()  {
    private lateinit var binding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        confirmPasswordListener()
        passwordFocusListener()

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
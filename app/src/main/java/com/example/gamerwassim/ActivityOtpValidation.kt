package com.example.gamerwassim

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.gamerwassim.databinding.ActivityOtpValidationBinding
import com.google.android.material.snackbar.Snackbar

class ActivityOtpValidation : AppCompatActivity() {
    private lateinit var binding: ActivityOtpValidationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpValidationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTextInputListeners()
        binding.btnResendCode.setOnClickListener {
            showSnackbar("Coming soon")
        }


    }

    private fun setupTextInputListeners() {
        val textInputList = listOf(
            binding.tiCode1,
            binding.tiCode2,
            binding.tiCode3,
            binding.tiCode4
        )

        for (i in 0 until textInputList.size) {
            val textInput = textInputList[i]
            textInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // Ne rien faire ici
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Ne rien faire ici
                }

                override fun afterTextChanged(s: Editable?) {
                    // Vérifier si la longueur du texte est supérieure à 1 caractère
                    if (s?.length ?: 0 > 1) {
                        // Supprimer tous les caractères sauf le dernier
                        s?.replace(0, s.length - 1, "")
                    }

                    // Passer automatiquement au champ suivant ou revenir au champ précédent
                    if (s.isNullOrEmpty()) {
                        if (i > 0) {
                            textInputList[i - 1].requestFocus()
                        }
                    } else if (i < textInputList.size - 1) {
                        textInputList[i + 1].requestFocus()
                    }
                }
            })
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()

    }

}

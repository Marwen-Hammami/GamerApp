package tn.sim.gamerapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import tn.sim.gamerapp.R
import tn.sim.gamerapp.databinding.LoginBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListeners()

        setInputsEmptyErrors()

    }

    private fun setOnClickListeners() {
        binding.btnRegisterNow.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.btnForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        val snack = Snackbar.make(binding.contextView,"Coming soon :)", Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(this, R.color.white))
        binding.btnFacebook.setOnClickListener {
            snack.show()
        }
        binding.btnGoogle.setOnClickListener {
            snack.show()
        }

        binding.btnLogIn.setOnClickListener {
            if (binding.emailTxt.text.toString().isNotEmpty() && binding.passwordTxt.text.toString().isNotEmpty()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                setEmailError()
                setPasswordError()
                val snackError = Snackbar.make(binding.contextView,"You have some errors in your inputs!", Snackbar.LENGTH_LONG)
                    .setTextColor(ContextCompat.getColor(this, R.color.white))
                snackError.show()
            }
        }

    }

    // Empty Inputs Errors START *************************************
    private fun setInputsEmptyErrors() {
        setEmailInputEmptyError()
        setPasswordInputEmptyError()
    }
    private fun setEmailInputEmptyError() {
        binding.emailTxt.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                setEmailError()
            }
        }
    }
    private fun setEmailError() {
        if (binding.emailTxt.text.toString().isEmpty()) {
            binding.EmailAddress.error = getString(R.string.not_empty)
        } else {
            binding.EmailAddress.error = null
        }
    }
    private fun setPasswordInputEmptyError() {
        binding.passwordTxt.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                setPasswordError()
            }
        }
    }
    private fun setPasswordError() {
        if (binding.passwordTxt.text.toString().isEmpty()) {
            binding.Password.error = getString(R.string.not_empty)
        }else {
            binding.Password.error = null
        }
    }
    // Empty Inputs Errors END ***************************************

}
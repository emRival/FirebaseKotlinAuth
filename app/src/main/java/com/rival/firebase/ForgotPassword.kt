package com.rival.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.rival.firebase.databinding.ActivityForgotPasswordBinding

class ForgotPassword : AppCompatActivity() {
lateinit var binding: ActivityForgotPasswordBinding
lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnResetPassword.setOnClickListener {
            val email = binding.edtInputEmail.text.toString()
            val edtEmail = binding.edtInputEmail

            if (email.isEmpty()){
                edtEmail.error = "Emailnya Cok!"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                edtEmail.error = "Email Ga sama gan"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(applicationContext, "Email Dah dikirim gan $email ", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                else{
                    edtEmail.error = "${it.exception?.message}"
                    edtEmail.requestFocus()

                }
            }
        }


    }
}
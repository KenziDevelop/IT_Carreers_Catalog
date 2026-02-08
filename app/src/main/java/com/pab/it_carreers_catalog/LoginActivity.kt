package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan password harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("app_pref", MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)
            val savedUsername = sharedPref.getString("username", "User")  // ambil username dari register

            if (email == savedEmail && password == savedPassword) {
                // Login berhasil → simpan status login + username (biar dashboard/profile ambil ini)
                sharedPref.edit().apply {
                    putBoolean("is_logged_in", true)
                    putString("user_email", email)
                    putString("username", savedUsername)  // pastikan username tersimpan
                    apply()
                }

                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Lupa Password (placeholder)
        binding.tvForgot.setOnClickListener {
            Toast.makeText(this, "Fitur lupa password (coming soon)", Toast.LENGTH_SHORT).show()
        }

        // Google & Facebook (placeholder)
        binding.btnGoogle.setOnClickListener {
            Toast.makeText(this, "Login Google (coming soon)", Toast.LENGTH_SHORT).show()
        }

        binding.btnFacebook.setOnClickListener {
            Toast.makeText(this, "Login Facebook (coming soon)", Toast.LENGTH_SHORT).show()
        }

        // Link Sign Up
        binding.tvSignup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}
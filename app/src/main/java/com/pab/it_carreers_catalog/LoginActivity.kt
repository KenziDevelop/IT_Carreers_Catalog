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

        // Tombol Sign In
        binding.btnSignin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.tilEmail.error = "Email wajib diisi"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = "Password wajib diisi"
                return@setOnClickListener
            }

            // Validasi sederhana (nanti bisa diganti dengan Firebase Auth atau SharedPreferences)
            if (email == "user@example.com" && password == "password123") {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                // Pindah ke Main/Dashboard setelah login sukses
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Sign Up Link
        binding.tvSignupLink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Lupa Password (placeholder)
        binding.tvForgot.setOnClickListener {
            Toast.makeText(this, "Fitur lupa password belum tersedia", Toast.LENGTH_SHORT).show()
        }
    }
}
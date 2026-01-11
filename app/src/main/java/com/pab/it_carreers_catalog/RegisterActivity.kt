package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol Register
        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Reset error sebelum validasi
            binding.tilUsername.error = null
            binding.tilEmail.error = null
            binding.tilPassword.error = null

            when {
                username.isEmpty() -> {
                    binding.tilUsername.error = "Username wajib diisi"
                    return@setOnClickListener
                }
                email.isEmpty() -> {
                    binding.tilEmail.error = "Email wajib diisi"
                    return@setOnClickListener
                }
                !email.contains("@") -> {
                    binding.tilEmail.error = "Format email tidak valid"
                    return@setOnClickListener
                }
                password.isEmpty() -> {
                    binding.tilPassword.error = "Password wajib diisi"
                    return@setOnClickListener
                }
                password.length < 6 -> {
                    binding.tilPassword.error = "Password minimal 6 karakter"
                    return@setOnClickListener
                }
                else -> {
                    // Simpan data ke SharedPreferences (sementara, nanti bisa pakai Firebase)
                    val prefs = getSharedPreferences("user_data", MODE_PRIVATE)
                    val editor = prefs.edit()
                    editor.putString("username", username)
                    editor.putString("email", email)
                    editor.putString("password", password) // Hanya untuk prototype! Jangan simpan plain text di real app
                    editor.apply()

                    Toast.makeText(this, "Registrasi berhasil! Silakan login", Toast.LENGTH_SHORT).show()

                    // Pindah ke Login
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
        }

        // Login Link
        binding.tvLoginLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
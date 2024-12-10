package com.example.feedbackformapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() { // наследуемся от AppCompatActivity
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etMessage: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etMessage = findViewById(R.id.et_message)
        btnSubmit = findViewById(R.id.btn_submit)
        btnCancel = findViewById(R.id.btn_cancel)

        btnSubmit.setOnClickListener { submitForm() }
        btnCancel.setOnClickListener { resetForm() }
    }

    private fun submitForm() {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val message = etMessage.text.toString()

        if (name.isBlank() || email.isBlank() || message.isBlank()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Форма отправлена", Toast.LENGTH_SHORT).show()
            resetForm()
        }
    }

    private fun resetForm() {
        etName.text.clear()
        etEmail.text.clear()
        etMessage.text.clear()
    }
}

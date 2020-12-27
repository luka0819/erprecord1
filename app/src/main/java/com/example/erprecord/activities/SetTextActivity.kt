package com.example.erprecord.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.erprecord.R
import com.example.erprecord.config.App

class SetTextActivity : AppCompatActivity() {

    private lateinit var updateButtonText: TextView
    private lateinit var updateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_text)

        updateButtonText = findViewById(R.id.updateButtonText)
        updateButton = findViewById(R.id.updateButton)

        val extras = intent.extras

        val oldString = extras?.getString("NAME")

        if (oldString?.isEmpty() == true) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            return
        }

        updateButton.setOnClickListener {

            val t = updateButtonText.text.toString()

            if (t.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            App.instance.db.buttonDao().update(oldString!!, t)

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }


    }

}
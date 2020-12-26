package com.example.erprecord.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.erprecord.R
import com.example.erprecord.config.App
import com.example.erprecord.entities.Buttons

class settings : AppCompatActivity() {

    private lateinit var addchoice: EditText
    private lateinit var add: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val buttonDao = App.instance.db.buttonDao()

        addchoice = findViewById(R.id.addchoice)
        add = findViewById(R.id.add)

        add.setOnClickListener {

            val text = addchoice.text.toString()

            if (text.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val b = Buttons(uid = null, buttonName = text)

            buttonDao.insertAll(b)

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

    }

}
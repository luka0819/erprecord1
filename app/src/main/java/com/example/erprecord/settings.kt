package com.example.erprecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class settings : AppCompatActivity() {
    private lateinit var addchoice: EditText
    private lateinit var add: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        addchoice = findViewById(R.id.addchoice)
        add = findViewById(R.id.add)


    }
}
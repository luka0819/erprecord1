package com.example.erprecord.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erprecord.R
import com.example.erprecord.adapters.ButtonsAdapter
import com.example.erprecord.config.App

class MainActivity : AppCompatActivity() {

    private lateinit var setting: ImageButton

    private lateinit var buttonsAdapter: ButtonsAdapter

    private lateinit var buttonsRecyclerView: RecyclerView

    private lateinit var statisticImageButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setting = findViewById(R.id.setting)
        buttonsRecyclerView = findViewById(R.id.buttonsList)
        statisticImageButton = findViewById(R.id.imageButton)

        statisticImageButton.setOnClickListener {
            startActivity(Intent(this, StatisticsActivity::class.java))
        }

        initView()

        setting.setOnClickListener {
            startActivity(Intent(this, settings::class.java))
            finish()
        }

        val all = App.instance.db.buttonDao().getAll()
        buttonsAdapter.updateButtons(all)



    }

    private fun initView() {
        buttonsAdapter = ButtonsAdapter(ArrayList())
        buttonsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = buttonsAdapter
        }
    }

}
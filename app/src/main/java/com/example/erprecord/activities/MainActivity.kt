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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setting = findViewById(R.id.setting)
        buttonsRecyclerView = findViewById(R.id.buttonsList)

        initView()

        setting.setOnClickListener {
            startActivity(Intent(this, settings::class.java))
            finish()
        }

        val all = App.instance.db.buttonDao().getAll()
        buttonsAdapter.updateButtons(all)

//        buttona.setOnClickListener {
//
//            val builder = AlertDialog.Builder(this)
//            //set title for alert dialog
//            builder.setTitle(R.string.dialogTitle)
//            //set message for alert dialog
//            builder.setMessage(R.string.dialogMessage)
//
//
//            //performing positive action
//            builder.setPositiveButton("Yes") { dialogInterface, which ->
//                Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
//            }
//
//            //performing negative action
//            builder.setNegativeButton("No") { dialogInterface, which ->
//                Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
//            }
//            // Create the AlertDialog
//            val alertDialog: AlertDialog = builder.create()
//            // Set other dialog properties
//            alertDialog.setCancelable(false)
//            alertDialog.show()
//
//        }


    }

    private fun initView() {
        buttonsAdapter = ButtonsAdapter(ArrayList())
        buttonsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = buttonsAdapter
        }
    }

}
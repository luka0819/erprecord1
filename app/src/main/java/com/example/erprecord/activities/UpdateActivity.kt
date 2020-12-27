package com.example.erprecord.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erprecord.R
import com.example.erprecord.adapters.ButtonsAdapter
import com.example.erprecord.config.App
import com.example.erprecord.entities.Buttons
import com.example.erprecord.utils.ItemClickCallback

class UpdateActivity : AppCompatActivity(), ItemClickCallback {

    private lateinit var buttonsAdapter: ButtonsAdapter
    private lateinit var buttonsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        buttonsRecyclerView = findViewById(R.id.updateButtonsList)

        initView()

        val all = App.instance.db.buttonDao().getAll()
        buttonsAdapter.updateButtons(all)

        ButtonsAdapter.itemClickCallback = this

    }

    private fun initView() {
        buttonsAdapter = ButtonsAdapter(ArrayList(), true)
        buttonsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@UpdateActivity, 2)
            adapter = buttonsAdapter
        }
    }

    override fun onClick(buttons: Buttons) {
        val i = Intent(this, SetTextActivity::class.java)
        i.putExtra("NAME", buttons.buttonName)
        startActivity(i)
        finish()
    }

}
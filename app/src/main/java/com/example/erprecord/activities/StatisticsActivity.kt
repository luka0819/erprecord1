package com.example.erprecord.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erprecord.R
import com.example.erprecord.adapters.StatisticsAdapter
import com.example.erprecord.config.App

class StatisticsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var statisticsAdapter: StatisticsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        this.init()

        val all = App.instance.db.statisticDao().getAll()
        statisticsAdapter.update(all)

    }

    private fun init() {
        recyclerView = findViewById(R.id.statisticList)
        statisticsAdapter = StatisticsAdapter(ArrayList())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@StatisticsActivity)
            adapter = statisticsAdapter
        }
    }

}
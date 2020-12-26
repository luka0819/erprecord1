package com.example.erprecord.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.erprecord.dao.ButtonDao
import com.example.erprecord.dao.StatisticDao
import com.example.erprecord.entities.Buttons
import com.example.erprecord.entities.Statistic

/*
* Created by ნიკოლოზ კაციტაძე on 12/26/20
*/

@Database(entities = [Buttons::class, Statistic::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun buttonDao(): ButtonDao
    abstract fun statisticDao(): StatisticDao
}
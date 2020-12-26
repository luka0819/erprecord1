package com.example.erprecord.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.erprecord.dao.ButtonDao
import com.example.erprecord.entities.Buttons

/*
* Created by ნიკოლოზ კაციტაძე on 12/26/20
*/

@Database(entities = [Buttons::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun buttonDao(): ButtonDao
}
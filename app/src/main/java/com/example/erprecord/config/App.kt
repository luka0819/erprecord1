package com.example.erprecord.config

import android.app.Application
import androidx.room.Room

/*
* Created by ნიკოლოზ კაციტაძე on 12/26/20
*/

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()

        instance = this

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "AppDB"
        ).allowMainThreadQueries().build()

    }

}
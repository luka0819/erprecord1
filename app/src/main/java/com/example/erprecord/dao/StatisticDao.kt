package com.example.erprecord.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.erprecord.entities.Statistic

/*
* Created by ნიკოლოზ კაციტაძე on 12/26/20
*/

@Dao
interface StatisticDao {

    @Query("SELECT * FROM STATISTIC")
    fun getAll(): List<Statistic>

    @Insert
    fun insertAll(vararg statistic: Statistic)

}
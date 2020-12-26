package com.example.erprecord.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.erprecord.entities.Buttons

/*
* Created by ნიკოლოზ კაციტაძე on 12/26/20
*/

@Dao
interface ButtonDao {

    @Query("SELECT * FROM BUTTONS")
    fun getAll(): List<Buttons>

    @Insert
    fun insertAll(vararg users: Buttons)

    @Query("DELETE FROM BUTTONS WHERE uid = :uid")
    fun deleteButton(uid: Long)

}
package com.example.erprecord.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Created by ნიკოლოზ კაციტაძე on 12/26/20
*/

@Entity
data class Buttons(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "first_name") val buttonName: String?,
)
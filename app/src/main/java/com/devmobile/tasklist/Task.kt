package com.devmobile.tasklist

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tbl_task")
class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    var isDone:Boolean = false)
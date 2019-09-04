package com.devmobile.tasklist

import androidx.room.*

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("select * from tbl_task")
    fun getAll(): List<Task>

    @Query("select * from tbl_task where id=:idTask")
    fun getById(idTask: Int): Task
}
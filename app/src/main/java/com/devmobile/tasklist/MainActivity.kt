package com.devmobile.tasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewAdapter = TaskAdapter()
        val viewManager = LinearLayoutManager(this)

        db = getDatabase(this)

        viewAdapter.update = {
            updateTask(it)
        }

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val taskList = db.taskDao().getAll()

        viewAdapter.updateItens(taskList)

        btAdd.setOnClickListener {
            val task = Task(0, etTaskName.text.toString())

            db.taskDao().insert(task)
            viewAdapter.updateItens(task)
        }

    }

    fun updateTask(task: Task){
        db.taskDao().update(task)
    }
}

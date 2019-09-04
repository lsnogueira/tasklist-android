package com.devmobile.tasklist

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.ViewHolder>(){

    private val items = mutableListOf<Task>()

    fun updateItens(task: Task){
        items.add(task)
        notifyDataSetChanged()
    }

    fun updateItens(taskList: List<Task>){
        items.addAll(taskList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = items[position].name
        holder.checkBox.isChecked = items[position].isDone
        holder.textView.updateStrike(items[position].isDone)

        holder.checkBox.setOnClickListener {
            items[position].isDone = holder.checkBox.isChecked
            holder.textView.updateStrike(items[position].isDone)
        }

    }

    private fun TextView.updateStrike(isDone:Boolean){
        this.paintFlags = if(isDone)
            Paint.STRIKE_THRU_TEXT_FLAG
        else
            Paint.LINEAR_TEXT_FLAG
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val checkBox = itemView.findViewById<CheckBox>(R.id.ckTask)
        val textView = itemView.findViewById<TextView>(R.id.tvTaskName)
    }
}
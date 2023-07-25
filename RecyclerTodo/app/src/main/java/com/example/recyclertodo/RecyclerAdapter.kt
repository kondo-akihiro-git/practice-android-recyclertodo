package com.example.recyclertodo

import android.app.AlertDialog
//import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
//import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val todoList: ArrayList<TodoData>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolderItem>() {



    inner class ViewHolderItem(v : View, rAdapter:RecyclerAdapter) :RecyclerView.ViewHolder(v){
        val tvHolder :TextView = v.findViewById(R.id.tv)

        //fixing : "dialog"
        //////////////////////////////////////
        init {
            v.setOnClickListener{
                val position :Int = adapterPosition
                val listPosition = todoList[position]

                AlertDialog.Builder(v.context)
                    .setTitle("focusing on ${listPosition.myTodo}")
                    .setMessage("do you wanna delete?")
                    .setPositiveButton("Yes", ){ _, _ ->
                        todoList.removeAt(position)
                        rAdapter.notifyItemRemoved(position)


                    }
                    .setNegativeButton("No", null)
                    .show()

                //Toast.makeText(v.context, "${listPosition.myTodo}",Toast.LENGTH_SHORT).show()
            }
        }




        /////////////////////////////////////

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)

        return ViewHolderItem(itemXml, this)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
       val currentItem = todoList[position]
        holder.tvHolder.text= currentItem.myTodo


    }

    override fun getItemCount(): Int {
        return todoList.size
    }


}
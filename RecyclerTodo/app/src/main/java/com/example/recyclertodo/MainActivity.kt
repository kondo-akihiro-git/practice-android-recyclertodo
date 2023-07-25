package com.example.recyclertodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var addList = ArrayList<TodoData>()
    private lateinit var recyclerView: RecyclerView
    private var recyclerAdapter = RecyclerAdapter(addList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager= LinearLayoutManager(this)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
            val et:EditText = findViewById(R.id.et)
            val data= TodoData(et.text.toString())
            addList.add(data)
            recyclerAdapter.notifyItemInserted(addList.lastIndex)

            et.text = null
        }
    }
}
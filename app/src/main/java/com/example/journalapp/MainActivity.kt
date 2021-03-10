package com.example.journalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    lateinit var floatAction: View
    var days = ArrayList<Day>()
    var dbHelper = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatAction = findViewById(R.id.floating)
        recyclerView =findViewById(R.id.recyclerView)
        floatActionButton()
        addList()
        recView()
    }

    fun recView(){
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = DayAdapter(days)
    }
    fun floatActionButton(){
        floatAction.setOnClickListener {
            startActivity(Intent(this@MainActivity,Add::class.java))
        }
    }
    fun addList(){
        val res = dbHelper.allData
        if(res.count!=0){
            while(res.moveToNext()){
                days.add(Day(res.getString(1),res.getString(2)))
                println(res.getString(1)+" "+res.getString(2))
            }
        }

    }

}
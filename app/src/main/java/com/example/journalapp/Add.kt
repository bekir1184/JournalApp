package com.example.journalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class Add : AppCompatActivity() {
    lateinit var content: EditText
    lateinit var button: Button
    var dbHelper = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)



        content = findViewById(R.id.content)
        button = findViewById(R.id.addButton)

        val acitionbar = supportActionBar
        acitionbar!!.title ="Add"
        acitionbar.setDisplayHomeAsUpEnabled(true)

        insert()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    fun insert(){
        button.setOnClickListener {
            try {
                dbHelper.insertData(content.text.toString(),getDate())
                println(content.text.toString() +" "+getDate() )
            }catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
    fun getDate():String{
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        return currentDate
    }
}
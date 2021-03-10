package com.example.journalapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY "+ "AUTOINCREMENT,CONTENT TEXT,DATE TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME)
        onCreate(db)
    }
    fun insertData(content:String ,date:String){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2,content)
        contentValues.put(COL_3,date)
        db.insert(TABLE_NAME,null,contentValues)
    }
    fun updateData(id:String,content: String,date: String):Boolean{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1,id)
        contentValues.put(COL_2,content)
        contentValues.put(COL_3,date)
        db.update(TABLE_NAME ,contentValues ,"ID=?" , arrayOf(id))
        return true
    }
    fun deleteData(id: String):Int{
        val db =this.writableDatabase
        return db.delete(TABLE_NAME,"ID=?", arrayOf(id))
    }

    val allData:Cursor
        get(){
            val db = this.writableDatabase
            val res=db.rawQuery("SELECT * FROM "+TABLE_NAME,null)
            return res
        }
    companion object{
        val DATABASE_NAME ="dayList.db"
        val TABLE_NAME ="daylist_table"
        val COL_1 ="ID"
        val COL_2 ="CONTENT"
        val COL_3="DATE"
    }
}
package com.example.f5onz.applicationprojet

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.*
import android.widget.Toast
import com.example.f5onz.applicationprojet.tool.Animaux
import kotlinx.android.synthetic.main.activity_mes_animaux.*

val DATABASE_NAME ="MyDB"
val TABLE_NAME = "Animaux"
val COL_ID ="id"
val COL_NOM ="nom"
val COL_PRENOM="prenom"
val COL_RACE="race"
val COL_SEXE="sexe"

class DataBase(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NOM + " VARCHAR(256),"+
                COL_PRENOM + " VARCHAR(256),"+
                COL_RACE + "  VARCHAR(256),"+
                COL_SEXE + " VARCHAR(256))";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData( animaux: Animaux  ){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NOM, animaux.nom)
        cv.put(COL_PRENOM, animaux.prenom)
        cv.put(COL_RACE, animaux.race)
        cv.put(COL_SEXE, animaux.sexe)
        var result = db.insert(TABLE_NAME, null, cv)
        if(result == -1.toLong())
            Toast.makeText(context,"ECHEC", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"SUCCES", Toast.LENGTH_SHORT).show()
    }
    fun readData() : MutableList<Animaux>{
        var list : MutableList<Animaux> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var animal = Animaux()
                animal.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                animal.nom = result.getString(result.getColumnIndex(COL_NOM))
                animal.prenom = result.getString(result.getColumnIndex(COL_PRENOM))
                animal.race = result.getString(result.getColumnIndex(COL_RACE))
                animal.sexe = result.getString(result.getColumnIndex(COL_NOM))
                list.add(animal)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null,null)
        db.close()
    }


    fun updateData() {
        val db = this.writableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var cv = ContentValues()
                cv.put(COL_ID, (result.getInt(result.getColumnIndex(COL_ID)) + 1))
                db.update(TABLE_NAME, cv, COL_ID + "=? AND " + COL_NOM + "=?"+ COL_PRENOM + "=?"+ COL_RACE + "=?"+ COL_SEXE + "=?",
                        arrayOf(result.getString(result.getColumnIndex(COL_ID)),
                                result.getString(result.getColumnIndex(COL_NOM)),
                                result.getString(result.getColumnIndex(COL_PRENOM)),
                                result.getString(result.getColumnIndex(COL_RACE)),
                                result.getString(result.getColumnIndex(COL_SEXE))))
            } while (result.moveToNext())
        }

        result.close()
        db.close()
    }
}
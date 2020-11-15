package com.example.f5onz.applicationprojet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f5onz.applicationprojet.tool.Animaux
import kotlinx.android.synthetic.main.activity_mes_animaux.*

class MesAnimaux : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mes_animaux)

        val context = this
        var db = DataBase(context)

        btn_insert.setOnClickListener ({
            if (nom.text.toString().length > 0 && prenom.text.toString().length > 0 && race.text.toString().length > 0 &&  sexe.text.toString().length > 0) {
                var animal = Animaux(nom = nom.text.toString(), prenom = prenom.text.toString(), race = race.text.toString(), sexe = sexe.text.toString())
                db.insertData(animal)
            } else {
                Toast.makeText(context, "Remplissez tout les champs", Toast.LENGTH_SHORT).show()
            }
        })
        btn_read.setOnClickListener({
            var data = db.readData()
            tvResult.text = ""
            for (i in 0..(data.size - 1)) {
                tvResult.append(data.get(i).id.toString() + " " + data.get(i).nom + " " + data.get(i).prenom + data.get(i).race + " " + data.get(i).sexe +   "\n")
            }
        })

        btn_update.setOnClickListener({
            db.updateData()
            btn_read.performClick()
        })

        btn_delete.setOnClickListener({
            db.deleteData()
            btn_read.performClick()
        })
    }
}
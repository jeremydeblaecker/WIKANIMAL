package com.example.f5onz.applicationprojet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_list_adapter.*

class ListAdapterChiens : AppCompatActivity() {

    var ChiensList = Array<Especeschiens>(7, { Especeschiens("???", 0) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_adapter)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        voirEspeceschiens()
        androidVersionRecyclerView.layoutManager = LinearLayoutManager(this)
        androidVersionRecyclerView.adapter = EspecesChiensAdaptater(ChiensList)
    }

    private fun voirEspeceschiens() {
        var nameArray = resources.getStringArray(R.array.especeChiens)
        val imgArray = arrayOf(R.drawable.allemand, R.drawable.beagle, R.drawable.golden, R.drawable.husky, R.drawable.jack, R.drawable.labrador, R.drawable.yorkshire)
        for (i in 0..(nameArray.size-1))
            ChiensList[i] = Especeschiens(nameArray[i], imgArray[i])
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}


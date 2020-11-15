package com.example.f5onz.applicationprojet

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.f5onz.applicationprojet.tool.replace
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger, NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        replace(MainFragment())
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //Menu superieur
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> {
                this.finish()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    //Bouton menu cote
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //Navigation dans le menu
        when (item.itemId) {

            R.id.chien -> {
                val intent = Intent(this@MainActivity, ListAdapterChiens::class.java)
                startActivity(intent)
            }

            R.id.anim -> {
                val intent = Intent(this@MainActivity, MesAnimaux::class.java)
                startActivity(intent)
            }

            R.id.nav_anko -> {
                val intent = Intent(this@MainActivity, ListAdapterChiens::class.java)
                startActivity(intent)
            }


        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}

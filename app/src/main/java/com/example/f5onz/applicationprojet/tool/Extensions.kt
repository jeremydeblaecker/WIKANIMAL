package com.example.f5onz.applicationprojet.tool

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.f5onz.applicationprojet.R

/**
 * Created by f5onz on 24/10/2018.
 */
fun AppCompatActivity.replace(frag: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.content, frag).commit()
}
package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentStart()
    }

    private fun fragmentStart() {
        val manager: FragmentManager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.afragment, HomeFragment(), "YOUR_FRAGMENT_STRING_TAG")
        transaction.commit()
    }
}
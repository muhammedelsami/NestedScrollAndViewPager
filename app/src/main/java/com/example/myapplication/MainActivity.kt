package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    lateinit var nsd : NestedScrollView
    lateinit var tabLayout : TabLayout
    lateinit var newTabLayout : TabLayout
    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newTabLayout = findViewById(R.id.new_tabs)

        tabLayout = findViewById(R.id.tabs)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager)
        nsd = findViewById(R.id.nested_id)


        val adapter = ViewPagerAdapter(this)
        viewPager2.adapter = adapter

        TabLayoutMediator(
            tabLayout, viewPager2
        ) { tab, position ->
            tab.text = "Tab " + (position + 1)
        }.attach()

        TabLayoutMediator(
            newTabLayout, viewPager2
        ) { tab, position ->
            tab.text = "Tab " + (position + 1)
        }.attach()


        hideShowNewTabLayout()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun hideShowNewTabLayout() {
        newTabLayout.isVisible = nsd.isViewVisible(tabLayout)
        nsd.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            newTabLayout.isVisible = nsd.isViewVisible(tabLayout)
        }
    }

    private fun NestedScrollView.isViewVisible(view: View) : Boolean {
        val  scrollBounds = Rect()
        this.getDrawingRect(scrollBounds)
        val top = view.y
        val bottom = view.height + top
        return scrollBounds.top > top
    }
}
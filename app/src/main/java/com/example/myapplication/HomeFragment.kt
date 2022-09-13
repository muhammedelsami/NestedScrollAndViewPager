package com.example.myapplication

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    lateinit var nsd: NestedScrollView
    lateinit var tabLayout: TabLayout
    lateinit var newTabLayout: TabLayout
    private var fragments = mutableListOf(Page1(), Page2())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newTabLayout = view.findViewById(R.id.new_tabs)

        tabLayout = view.findViewById(R.id.tabs)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.view_pager)
        nsd = view.findViewById(R.id.nested_id)


        val adapter = ViewPagerAdapter(context as FragmentActivity, fragments)
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


    private fun NestedScrollView.isViewVisible(view: View): Boolean {
        val scrollBounds = Rect()
        this.getDrawingRect(scrollBounds)
        val top = view.y
        return scrollBounds.top > top
    }

}
package com.example.loginwithviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPager)
        val tab = findViewById<TabLayout>(R.id.tabLayout)

        tab.setupWithViewPager(pager)

        val titulo = listOf("Sign in", "Sign up")

        val fragment = listOf(
            SingInFragment.newInstance("Sara", "Alves"),
            SignUpFragment.newInstance("", "")
        )

        pager.adapter = ViewPagerAdapter(fragment, titulo, supportFragmentManager)
    }
}
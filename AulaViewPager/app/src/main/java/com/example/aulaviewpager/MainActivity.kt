package com.example.aulaviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPager)
        val tab = findViewById<TabLayout>(R.id.tabLayout)

        // Faz com que o tab use o viewPager
        tab.setupWithViewPager(pager)

//        val fragments = listOf(
//            PrimeiroFragment(), PrimeiroFragment(), PrimeiroFragment()
//        )

        val titulos = listOf(
           getString(R.string.home), getString(R.string.biblioteca), getString(R.string.favoritos)
        )

        val fragments = listOf(
            PrimeiroFragment.newInstance("Sara", true),
            PrimeiroFragment.newInstance("Julia", false),
            PrimeiroFragment.newInstance("Roberto", true)
        )

        pager.adapter = ViewPagerAdapter(fragments, titulos, supportFragmentManager)

        // adiciona icones na tab
        tab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_menu_book_24)
        tab.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_star_24)

        // adiciona badge na segunda tab
        tab.getTabAt(1)!!.orCreateBadge.apply {
            number = 10
            maxCharacterCount = 2
            isVisible = true
        }



        // a ideia é fazer com que ao clicar na segunda tab, que é a que tem notificação ,
        // essa notificação seja ocultado, pois o usuário j[a leu as novidades dela
        tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(selected: TabLayout.Tab?) {
                if(selected!!.position == 1){

                    tab.getTabAt(1)!!.badge?.isVisible = false

                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

        })
    }
}
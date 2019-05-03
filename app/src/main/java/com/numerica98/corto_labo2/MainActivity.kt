package com.numerica98.corto_labo2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.numerica98.corto_labo2.constants.consts
import com.numerica98.corto_labo2.fragments.ButtonFragment
import com.numerica98.corto_labo2.fragments.ColorFragment

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonsListenerTools {

    val col1 = ColorFragment()
    val col2 = ColorFragment()
    val col3 = ColorFragment()
    val fragment_list = listOf<ColorFragment>(col1,col2,col3)
    var curr: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialFragment()

    }

    private fun changeFragment(newFragment: ColorFragment){
        supportFragmentManager.beginTransaction().replace(R.id.colorFragmentHolder, newFragment).commit()
    }

    private fun setInitialFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.colorFragmentHolder, col1).commit()
    }

    override fun onClick(nav_direction: String) {
        if(nav_direction == consts.left_ID){
            if(curr == 0){
                curr = 2
                changeFragment(fragment_list[curr])
            }
            else{
                curr -=1
                changeFragment(fragment_list[curr])
            }
        }
        if(nav_direction == consts.right_ID){
            if(curr == 2){
                curr = 0
                changeFragment(fragment_list[curr])
            }
            else{
                curr +=1
                changeFragment(fragment_list[curr])
            }
        }
    }
}

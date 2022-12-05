package com.shashi.shashi_dce_desk.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.shashi.shashi_dce_desk.Fragments.HolidayListFragment

class HolidayFragmentAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
       
//        return 2
        return 1
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->{
                return HolidayListFragment()
            }
//
//            1-> {
//                return CalendarFragment()
//            }
            else ->{
                return  HolidayListFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        
        var title :String =""
        
        if(position ==0) title = "Holidays List"
       // else if(position  == 1) title = "Calendar"
        
        return title
    }
}
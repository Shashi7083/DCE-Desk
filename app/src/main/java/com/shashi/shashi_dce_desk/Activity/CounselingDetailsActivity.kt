package com.shashi.shashi_dce_desk.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.shashi_dce_desk.R
import com.google.android.material.appbar.AppBarLayout
import com.shashi.shashi_dce_desk.Fragments.*


class CounselingDetailsActivity : AppCompatActivity() {

   lateinit var  toolbar: androidx.appcompat.widget.Toolbar
   lateinit var appbar : AppBarLayout
   lateinit var frameLayout :FrameLayout
   var key :String = ""



        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_councelling_details)


            frameLayout = findViewById(R.id.frameLayout)
            toolbar = findViewById(R.id.counselingToolbar)
            appbar = findViewById(R.id.counselingAppbar)


            setUpToolbar()




            key = intent.getStringExtra("data").toString()

            val transaction = supportFragmentManager.beginTransaction()

            if (getSupportActionBar() != null){
                getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
                getSupportActionBar()?.setDisplayShowHomeEnabled(true);
            }

//Toast.makeText(this@CounselingDetailsActivity,key,Toast.LENGTH_LONG).show()

            if(key.equals("Counseling")){
                  supportActionBar?.title="Counseling "
                 val  fragment = CounselingFragment()
                transaction.replace(R.id.frameLayout,fragment)
                transaction.commit()
            }

            if(key.equals("Student Search")){
               // supportActionBar?.title = "Student Search"
                appbar.visibility = View.GONE
                val fragment = StudentFragment()
                transaction.replace(R.id.frameLayout,fragment)
                transaction.commit()
            }

            if(key.equals("Faculty Search")){
                supportActionBar?.title="Faculty"
                val  fragment = FacultyFragment()
                transaction.replace(R.id.frameLayout,fragment)
                transaction.commit()
            }

            if(key.equals("Syllabus")){
                supportActionBar?.title="Syllabus"
                val  fragment = SyllabusFragment()
                transaction.replace(R.id.frameLayout,fragment)
                transaction.commit()
            }

            if(key.equals("Holidays")){
                supportActionBar?.title="Holidays 2022"
                //appbar.visibility = View.GONE

//                val  fragment = HolidayFragment()
                val fragment = HolidayListFragment()
                transaction.replace(R.id.frameLayout,fragment)
                transaction.commit()
            }

            if(key.equals("Placements")){
                supportActionBar?.title="Placements"
                val  fragment = PlacementFragment()
                transaction.replace(R.id.frameLayout,fragment)
                transaction.commit()
            }

            if(key.equals("Queries")){
                supportActionBar?.title="Queries"
                val  fragment = QueriesFragment()
                transaction.replace(R.id.frameLayout,fragment)
                transaction.commit()
            }









    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.getItemId() === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title=""
    }



}
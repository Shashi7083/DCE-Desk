package com.example.shashi_DCE_HelpDesk.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.shashi_DCE_HelpDesk.R
import com.google.android.material.navigation.NavigationView

class StartActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var getRoom :ImageView
    lateinit var councellingDetails : ImageView
    lateinit var txtCounseling :TextView
    lateinit var studentSearch :ImageView
    lateinit var facultySearch : ImageView
    lateinit var syllabus :ImageView
    lateinit var holidays :ImageView
    lateinit var placements : ImageView
    lateinit var queries :ImageView
 lateinit var drawerLayout: DrawerLayout
 lateinit var startNavigation : NavigationView

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportActionBar?.hide()




        toolbar = findViewById(R.id.startToolbar)
        getRoom = findViewById(R.id.getRooms)
        councellingDetails = findViewById(R.id.councellingDetails)
        txtCounseling = findViewById(R.id.txtCounseling)
        studentSearch = findViewById(R.id.studentSearch)
        facultySearch = findViewById(R.id.facultySearch)
        syllabus = findViewById(R.id.syllabus)
        holidays = findViewById(R.id.holidays)
        placements = findViewById(R.id.placements)
        queries = findViewById(R.id.queries)
        drawerLayout = findViewById(R.id.startDrawer)
        startNavigation = findViewById(R.id.startNavigation)


        startNavigation.setNavigationItemSelectedListener {



            when(it.itemId){
                R.id.starticon->{
                    Toast.makeText(this@StartActivity,"About",Toast.LENGTH_LONG).show();
                    val intent = Intent(this@StartActivity,AppInfoActivity::class.java)
                    startActivity(intent)
                }
            }

            return@setNavigationItemSelectedListener true
        }




           try {
               setUpToolbar()
           }catch (e : java.lang.Exception){
             Toast.makeText(this@StartActivity,"Change Dark Mode",Toast.LENGTH_LONG).show()
           }


        val actionBarDrawerToggle = ActionBarDrawerToggle(this@StartActivity,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()




        getRoom.setOnClickListener {
           val   intent = Intent(this@StartActivity, MainActivity::class.java)
           startActivity(intent)
        }
        councellingDetails.setOnClickListener {
            val  intent = Intent(this@StartActivity,CounselingDetailsActivity::class.java)
            intent.putExtra("data",txtCounseling.text.toString())
            startActivity(intent)
        }
        studentSearch.setOnClickListener {
            val  intent = Intent(this@StartActivity,CounselingDetailsActivity::class.java)
            intent.putExtra("data","Student Search")
            startActivity(intent)
        }
        facultySearch.setOnClickListener {
            val  intent = Intent(this@StartActivity,CounselingDetailsActivity::class.java)
            intent.putExtra("data","Faculty Search")
            startActivity(intent)
        }
        syllabus.setOnClickListener {
            val  intent = Intent(this@StartActivity,CounselingDetailsActivity::class.java)
            intent.putExtra("data","Syllabus")
            startActivity(intent)
        }
        holidays.setOnClickListener {
            val  intent = Intent(this@StartActivity,CounselingDetailsActivity::class.java)
            intent.putExtra("data","Holidays")
            startActivity(intent)
        }
        placements.setOnClickListener {
            val  intent = Intent(this@StartActivity,CounselingDetailsActivity::class.java)
            intent.putExtra("data","Placements")
            startActivity(intent)
        }
        queries.setOnClickListener {
            val  intent = Intent(this@StartActivity,CounselingDetailsActivity::class.java)
            intent.putExtra("data","Queries")
            startActivity(intent)
        }






    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "DCE Desk"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(R.menu.starticon,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item?.itemId
       when(id){

           android.R.id.home->{
               drawerLayout.openDrawer(GravityCompat.START)

           }
//           R.id.starticon ->{
//
//
//               val intent = Intent(this@StartActivity,AppInfoActivity::class.java)
//               startActivity(intent)
//           }



       }
        return super.onOptionsItemSelected(item)
    }

}
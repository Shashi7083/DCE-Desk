package com.example.shashi_DCE_HelpDesk.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import com.example.shashi_DCE_HelpDesk.R

class StartActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var getRoom :ImageView
    lateinit var councellingDetails : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportActionBar?.hide()

        toolbar = findViewById(R.id.startToolbar)
        getRoom = findViewById(R.id.getRooms)
        councellingDetails = findViewById(R.id.councellingDetails)
      try {
          setUpToolbar()
      }catch(e :Exception){
          Toast.makeText(this@StartActivity,"Please change to Light Mode",Toast.LENGTH_LONG).show()
          finish()
      }
        getRoom.setOnClickListener {
            val intent = Intent(this@StartActivity,MainActivity::class.java)
            startActivity(intent)
        }
        councellingDetails.setOnClickListener {
            val intent = Intent(this@StartActivity,CouncellingDetailsActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "DCE Desk"
    }
}
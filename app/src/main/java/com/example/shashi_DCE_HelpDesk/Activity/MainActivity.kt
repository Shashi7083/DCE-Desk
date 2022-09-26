package com.example.shashi_DCE_HelpDesk.Activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.shashi_DCE_HelpDesk.Adapter.RoomAdapter
import com.example.shashi_DCE_HelpDesk.Model.RoomModel
import com.example.shashi_DCE_HelpDesk.R
import com.example.shashi_DCE_HelpDesk.util.ConnectionManager

class MainActivity : AppCompatActivity() {

    lateinit var roomRecycler :RecyclerView
 lateinit var relativeLayout: RelativeLayout
 lateinit var progressBar: ProgressBar
    lateinit var roomAdapter : RoomAdapter
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      // supportActionBar?.hide()
        toolbar = findViewById(R.id.mainToolbar)
        roomRecycler = findViewById(R.id.roomRecycler)
        relativeLayout = findViewById(R.id.relativeLayout)
        progressBar = findViewById(R.id.progressBar)
        roomRecycler.layoutManager= LinearLayoutManager(this@MainActivity)
        relativeLayout.visibility = View.VISIBLE

       setUptoolbar()
        val roomList = arrayListOf<RoomModel>()

        if(ConnectionManager().checkConnectivity(this@MainActivity)) {


            val queue = Volley.newRequestQueue(this)
            val url =
                "https://script.google.com/macros/s/AKfycbwEeK3U4kU6KQzOJZTSkFHGZJ9az8-INYzp2JuwV5axLxZI_14sMKHq5-fOwkFjsR5c/exec"
            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                { response ->
                    //   textView.text = "Response: %s".format(response.toString())

                    val data = response.getJSONArray("bookList")

                    for (i in 0 until data.length()) {
                        val roomJsonObject = data.getJSONObject(i)


                        val roomObject = RoomModel(
                            roomJsonObject.getString("rno"),
                            roomJsonObject.getString("gps"),
                            roomJsonObject.getString("add"),
                            roomJsonObject.getString("landmark"),
                            roomJsonObject.getString("for"),
                            roomJsonObject.getString("roof"),
                            roomJsonObject.getString("pic"),
                            roomJsonObject.getString("rent")
                        )

                        roomList.add(roomObject)

                    }
                    relativeLayout.visibility = View.GONE
                    roomAdapter = RoomAdapter(this@MainActivity, roomList)
                    roomRecycler.adapter = roomAdapter

                },
                { error ->
                    Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_SHORT).show()
                    finish()
                }
            )
            queue.add(jsonObjectRequest)

        }else{
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("Error")
            dialog.setMessage("No Internet")

            dialog.setPositiveButton("Open Setting"){
                text ,listner->
                val settingIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingIntent)
               finish()
            }
            dialog.setNegativeButton("Exit"){
                text,listner->
//                ActivityCompat.finishAffinity(this@MainActivity)
                val intent =  Intent(this@MainActivity,StartActivity::class.java)
                startActivity(intent)
            }
            dialog.create()
            dialog.show()
        }
    }

    fun setUptoolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "DCE Desk - GetNest"
    }


}


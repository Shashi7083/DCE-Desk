package com.shashi.shashi_dce_desk.Activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import com.example.shashi_dce_desk.R


class AppInfoActivity : AppCompatActivity() {

    lateinit var infoToolbar: androidx.appcompat.widget.Toolbar
    lateinit var  btnShare : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_info)
        infoToolbar = findViewById(R.id.infoToolbar)
        setUpToolbar()
        btnShare = findViewById(R.id.btnShare)

        btnShare.setOnClickListener {

            var str = getString(R.string.share_app)
            var link = getString(R.string.app_link)
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, str+" "+link)
//                putExtra(Intent.EXTRA_TEXT,link)
                type = "text/plain"
            }

//            val shareIntent = Intent.createChooser(sendIntent, null)
//            startActivity(shareIntent)
            Toast.makeText(this@AppInfoActivity,"Available Soon",Toast.LENGTH_SHORT).show()
        }


    }

    private fun setUpToolbar() {
        setSupportActionBar(infoToolbar)
        supportActionBar?.title = "DCE Desk - Info"
    }
}
package com.example.shashi_DCE_HelpDesk.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import com.example.shashi_DCE_HelpDesk.R

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

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(infoToolbar)
        supportActionBar?.title = "DCE Desk - Info"
    }
}
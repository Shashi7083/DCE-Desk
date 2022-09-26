package com.example.shashi_DCE_HelpDesk.Activity

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.shashi_DCE_HelpDesk.R
import kotlin.math.max
import kotlin.math.min


class CounselingDetailsActivity : AppCompatActivity() {

   lateinit var  toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f
    private lateinit var imageView: ImageView

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_councelling_details)

            toolbar = findViewById(R.id.councToolbar)
            imageView = findViewById(R.id.councellingImg)
            setUpToolbar()

           // scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())

    }
    //For Image Zoom
//
//    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
//        scaleGestureDetector.onTouchEvent(motionEvent)
//        return true
//    }
//    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
//        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
//            scaleFactor *= scaleGestureDetector.scaleFactor
//            scaleFactor = max(0.1f, min(scaleFactor, 10.0f))
//            imageView.scaleX = scaleFactor
//            imageView.scaleY = scaleFactor
//            return true
//        }
//    }

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Document List"

    }

}
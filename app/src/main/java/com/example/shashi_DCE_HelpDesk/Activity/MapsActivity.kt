package com.example.shashi_DCE_HelpDesk.Activity


import android.annotation.SuppressLint

import android.content.pm.PackageManager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.shashi_DCE_HelpDesk.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {



    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val LOCATION_PERMISSION_REQUEST  = 1


    var location : String?=""
    var name : String?=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(com.example.shashi_DCE_HelpDesk.R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        if(intent !=null){
         location  =    intent.getStringExtra("location")
            name = intent.getStringExtra("name")
        }






    }


    private fun getLocationAccess(){



        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION )
                    ==PackageManager.PERMISSION_GRANTED ){
            map.isMyLocationEnabled = true
            }
        else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST
            )
        }


        }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
       // super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == LOCATION_PERMISSION_REQUEST){
            if(grantResults.contains(PackageManager.PERMISSION_GRANTED)){
                map.isMyLocationEnabled = true
            }
        }
        else{
            Toast.makeText(this,"user has not granted location access",Toast.LENGTH_LONG).show()
            finish()
        }
    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap



        val latlong = location?.split(",")?.toTypedArray()
        val latitude: Double? = latlong?.get(0)?.toDouble()
        val longitude:Double? = latlong?.get(1)?.toDouble()


        // Add a marker in Sydney and move the camera
        val latlng = LatLng(latitude!!, longitude!!)
        map.addMarker(MarkerOptions().position(latlng).title(name))
        map.moveCamera(CameraUpdateFactory.newLatLng(latlng))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,15f))

//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
//            PackageManager.PERMISSION_GRANTED &&
//            ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
//            PackageManager.PERMISSION_GRANTED) {
//            googleMap.setMyLocationEnabled(true);
//            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
//        } else {
//            Toast.makeText(this, "Location permission", Toast.LENGTH_LONG).show();
////            ActivityCompat.requestPermissions(
////                this, arrayOf(
////                    Manifest.permission.ACCESS_FINE_LOCATION,
////                    Manifest.permission.ACCESS_COARSE_LOCATION
////                ),""
////            )
//        }

        getLocationAccess()
    }










}
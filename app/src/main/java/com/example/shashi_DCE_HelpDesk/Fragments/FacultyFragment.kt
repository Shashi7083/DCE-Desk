package com.example.shashi_DCE_HelpDesk.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.shashi_DCE_HelpDesk.Activity.StartActivity
import com.example.shashi_DCE_HelpDesk.Adapter.FacultyAdapter
import com.example.shashi_DCE_HelpDesk.Model.FacultyModel
import com.example.shashi_DCE_HelpDesk.R
import com.example.shashi_DCE_HelpDesk.util.ConnectionManager
import com.facebook.shimmer.ShimmerFrameLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FacultyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FacultyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var  facultyRecycler : RecyclerView
    lateinit var facultyAdapter: FacultyAdapter
    lateinit var facultyProgressBar :ProgressBar
    lateinit var effect : ShimmerFrameLayout
    val facultyList = arrayListOf<FacultyModel>()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_faculty, container, false)

        facultyRecycler = view.findViewById(R.id.facultyRecycler)

        effect = view.findViewById(R.id.facultyEffect)
        facultyAdapter = FacultyAdapter(activity as Context , facultyList)

        val orientation = this.resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            facultyRecycler.layoutManager = LinearLayoutManager(activity)
        }
        else
            facultyRecycler.layoutManager = GridLayoutManager(activity as Context,2)


        if(ConnectionManager().checkConnectivity(activity as Context)) {

        val queue = Volley.newRequestQueue(activity as Context)
        val url = "https://script.google.com/macros/s/AKfycbwL2Kw7nq5UOV_wpZHqmuaQzObqzva59R3fW-8HvGp52aMgXknxf_xYHXhHGUSfhvc4/exec"



        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET,url,null,
            { response ->



                             val data = response.getJSONArray("facultyList")

                for(i in 0 until data.length()){
                    val facultyJsonObject = data.getJSONObject(i)


                    val facultyObject = FacultyModel(
                             facultyJsonObject.getString("sno"),
                             facultyJsonObject.getString("type"),
                        facultyJsonObject.getString("name"),
                        facultyJsonObject.getString("img"),
                        facultyJsonObject.getString("designation"),
                        facultyJsonObject.getString("department"),
                        facultyJsonObject.getString("website_url"),
                        facultyJsonObject.getString("phone"),
                        facultyJsonObject.getString("email"),
                        facultyJsonObject.getString("subject"),

                    )


                    facultyList.add(facultyObject)
                }

                facultyRecycler.adapter = facultyAdapter
                effect.startShimmer()
                effect.visibility = View.GONE
               facultyAdapter.notifyDataSetChanged()

                facultyRecycler.visibility = View.VISIBLE

        }, {error ->

             Toast.makeText(activity as Context,error.toString(),Toast.LENGTH_LONG).show()
        }){

        }
        queue.add(jsonObjectRequest)

        }else{
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error")
            dialog.setMessage("No Internet")

            dialog.setPositiveButton("Open Setting"){
                    text ,listner->
                val settingIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingIntent)

            }
            dialog.setNegativeButton("Exit"){
                    text,listner->
//                ActivityCompat.finishAffinity(this@MainActivity)
                val intent =  Intent(activity as Context, StartActivity::class.java)
                startActivity(intent)
            }
            dialog.create()
            dialog.show()


        }

        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FacultyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FacultyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
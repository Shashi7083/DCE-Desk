package com.shashi.shashi_dce_desk.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.example.shashi_dce_desk.R
import com.facebook.shimmer.ShimmerFrameLayout

import com.shashi.shashi_dce_desk.Activity.StartActivity
import com.shashi.shashi_dce_desk.Adapter.PlacementAdapter
import com.shashi.shashi_dce_desk.Model.PlacementModel
import com.shashi.shashi_dce_desk.util.ConnectionManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlacementFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlacementFragment : Fragment() {
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

    lateinit var  recycler :RecyclerView
    lateinit var adapter : PlacementAdapter
     var  studentList = arrayListOf<PlacementModel>()
    lateinit var effect : ShimmerFrameLayout
    lateinit var linear :LinearLayout

    lateinit var all : TextView
    lateinit var cse : TextView
    lateinit var eee : TextView
    lateinit var ce : TextView
    lateinit var me : TextView

    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_placement, container, false)

        recycler =  view.findViewById(R.id.recyclerP)
        all = view.findViewById(R.id.all)
        cse  = view.findViewById(R.id.cse)
        eee = view.findViewById(R.id.eee)
        ce = view.findViewById(R.id.ce)
        me = view.findViewById(R.id.me)
        effect = view.findViewById(R.id.placementEffect)
        linear = view.findViewById(R.id.linearP)

        all.setTextColor(Color.WHITE)
        all.setBackgroundResource(R.drawable.branck_black_bk)


        val orientation = this.resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            recycler.layoutManager = LinearLayoutManager(activity as Context)
        }
        else
        recycler.layoutManager = GridLayoutManager(activity as Context,2)




        if(ConnectionManager().checkConnectivity(activity as Context)) {

            val queue = Volley.newRequestQueue(activity as Context)
            val url = "https://script.google.com/macros/s/AKfycbz-09gsbKFj2_cAOYI7el0Dgf0zlSHJ9ljDDVk2D4MgM6uaiUO_SQ72Iy8wv8o54mfUDQ/exec"



            val jsonObjectRequest = object : JsonObjectRequest(
                Request.Method.GET,url,null,
                { response ->



                    val data = response.getJSONArray("placements")

                    for(i in 0 until data.length()){
                        val facultyJsonObject = data.getJSONObject(i)


                        val placementObject = PlacementModel(

                            facultyJsonObject.getString("name"),

                            facultyJsonObject.getString("branch"),
                            "( "+facultyJsonObject.getString("batch")+" )",

                            facultyJsonObject.getString("company"),
                            facultyJsonObject.getString("lpa"),
                            facultyJsonObject.getString("img")


                            )


                        studentList.add(placementObject)
                    }

                    recycler.adapter = adapter
//                    effect.startShimmer()
//                    effect.visibility = View.GONE
                    adapter.notifyDataSetChanged()
                    effect.startShimmer()
                    effect.visibility = View.GONE
                    recycler.visibility = View.VISIBLE
                    linear.visibility = View.VISIBLE

                }, {error ->

                    Toast.makeText(activity as Context,error.toString(), Toast.LENGTH_LONG).show()
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






all.setOnClickListener {
    all.setTextColor(Color.WHITE)
    all.setBackgroundResource(R.drawable.branck_black_bk)

    cse.setTextColor(Color.BLACK)
    cse.setBackgroundResource(R.drawable.branch_bk)

    eee.setTextColor(Color.BLACK)
    eee.setBackgroundResource(R.drawable.branch_bk)

    ce.setTextColor(Color.BLACK)
    ce.setBackgroundResource(R.drawable.branch_bk)

    me.setTextColor(Color.BLACK)
    me.setBackgroundResource(R.drawable.branch_bk)

    recycler.adapter=PlacementAdapter(activity as Context,studentList)
    adapter.notifyDataSetChanged()
}
        cse.setOnClickListener {

            all.setTextColor(Color.BLACK)
            all.setBackgroundResource(R.drawable.branch_bk)

            cse.setTextColor(Color.WHITE)
            cse.setBackgroundResource(R.drawable.branck_black_bk)

            eee.setTextColor(Color.BLACK)
            eee.setBackgroundResource(R.drawable.branch_bk)

            ce.setTextColor(Color.BLACK)
            ce.setBackgroundResource(R.drawable.branch_bk)

            me.setTextColor(Color.BLACK)
            me.setBackgroundResource(R.drawable.branch_bk)

            var cselist = arrayListOf<PlacementModel>()
            for(item in studentList){

                if(item.branch.equals("CSE") || item.branch.equals("cse")){
                    cselist.add(item)
                }

        }

            recycler.adapter=PlacementAdapter(activity as Context,cselist)
            adapter.notifyDataSetChanged()
        }

        eee.setOnClickListener {
            all.setTextColor(Color.BLACK)
            all.setBackgroundResource(R.drawable.branch_bk)

            cse.setTextColor(Color.BLACK)
            cse.setBackgroundResource(R.drawable.branch_bk)

            eee.setTextColor(Color.WHITE)
            eee.setBackgroundResource(R.drawable.branck_black_bk)

            ce.setTextColor(Color.BLACK)
            ce.setBackgroundResource(R.drawable.branch_bk)

            me.setTextColor(Color.BLACK)
            me.setBackgroundResource(R.drawable.branch_bk)


            var eeelist = arrayListOf<PlacementModel>()
            for(item in studentList){

                if(item.branch.equals("EEE") || item.branch.equals("eee")){
                    eeelist.add(item)
                }

            }

            recycler.adapter=PlacementAdapter(activity as Context,eeelist)
            adapter.notifyDataSetChanged()
        }

        ce.setOnClickListener {
            all.setTextColor(Color.BLACK)
            all.setBackgroundResource(R.drawable.branch_bk)

            cse.setTextColor(Color.BLACK)
            cse.setBackgroundResource(R.drawable.branch_bk)

            eee.setTextColor(Color.BLACK)
            eee.setBackgroundResource(R.drawable.branch_bk)

            ce.setTextColor(Color.WHITE)
            ce.setBackgroundResource(R.drawable.branck_black_bk)

            me.setTextColor(Color.BLACK)
            me.setBackgroundResource(R.drawable.branch_bk)


            var celist = arrayListOf<PlacementModel>()
            for(item in studentList){

                if(item.branch.equals("CE") || item.branch.equals("ce") || item.branch.equals("civil")||item.branch.equals("CIVIL")){
                    celist.add(item)
                }

            }

            recycler.adapter=PlacementAdapter(activity as Context,celist)
            adapter.notifyDataSetChanged()
        }

        me.setOnClickListener {

            all.setTextColor(Color.BLACK)
            all.setBackgroundResource(R.drawable.branch_bk)

            cse.setTextColor(Color.BLACK)
            cse.setBackgroundResource(R.drawable.branch_bk)

            eee.setTextColor(Color.BLACK)
            eee.setBackgroundResource(R.drawable.branch_bk)

            ce.setTextColor(Color.BLACK)
            ce.setBackgroundResource(R.drawable.branch_bk)

            me.setTextColor(Color.WHITE)
            me.setBackgroundResource(R.drawable.branck_black_bk)


            var melist = arrayListOf<PlacementModel>()
            for(item in studentList){

                if(item.branch.equals("ME") || item.branch.equals("me") || item.branch.equals("mech")||item.branch.equals("MECH")){
                    melist.add(item)
                }

            }

            recycler.adapter=PlacementAdapter(activity as Context,melist)
            adapter.notifyDataSetChanged()

        }


        adapter = PlacementAdapter(activity as Context , studentList)
        recycler.adapter = adapter

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlacementFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlacementFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
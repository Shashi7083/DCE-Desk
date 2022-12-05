package com.shashi.shashi_dce_desk.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.example.shashi_dce_desk.R

import com.facebook.shimmer.ShimmerFrameLayout
import com.shashi.shashi_dce_desk.Activity.StartActivity
import com.shashi.shashi_dce_desk.Adapter.FacultyAdapter
import com.shashi.shashi_dce_desk.Model.FacultyModel
import com.shashi.shashi_dce_desk.util.ConnectionManager


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

    lateinit var  facultyRecycler : RecyclerView
    lateinit var facultyAdapter: FacultyAdapter
    lateinit var facultyProgressBar :ProgressBar
    lateinit var effect : ShimmerFrameLayout
    val facultyList = arrayListOf<FacultyModel>()
    var displayList = arrayListOf<FacultyModel>()





    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_faculty, container, false)



        facultyRecycler = view.findViewById(R.id.facultyRecycler)

        effect = view.findViewById(R.id.facultyEffect)

        facultyAdapter = FacultyAdapter(activity as Context , displayList)


        val orientation = this.resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            facultyRecycler.layoutManager = LinearLayoutManager(activity)
        }
        else
            facultyRecycler.layoutManager = GridLayoutManager(activity as Context,2)


        if(ConnectionManager().checkConnectivity(activity as Context)) {

            if(facultyList.size == 0) {

                val queue = Volley.newRequestQueue(activity as Context)
                val url =
                    "https://script.google.com/macros/s/AKfycbwL2Kw7nq5UOV_wpZHqmuaQzObqzva59R3fW-8HvGp52aMgXknxf_xYHXhHGUSfhvc4/exec"


                val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url, null,
                    { response ->


                        val data = response.getJSONArray("facultyList")

                        for (i in 0 until data.length()) {
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
                        displayList.clear()
                        displayList.addAll(facultyList)
                        facultyAdapter.notifyDataSetChanged()

                        facultyRecycler.visibility = View.VISIBLE

                    }, { error ->

                        Toast.makeText(
                            activity as Context,
                            "Check Your Internet",
                            Toast.LENGTH_LONG
                        ).show()
                    }) {

                }
                queue.add(jsonObjectRequest)
            }else{

                facultyRecycler.adapter = facultyAdapter
                effect.startShimmer()
                effect.visibility = View.GONE
                displayList.clear()
                displayList.addAll(facultyList)
                facultyAdapter.notifyDataSetChanged()

                facultyRecycler.visibility = View.VISIBLE
            }

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



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.faculty_search,menu)

        val manager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
   val searchItem = menu?.findItem(R.id.mfacultySearch)

        val searchView = searchItem?.actionView as SearchView



        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                displayList.clear()
                var text = ""
                if(query.equals("CSE")||query.equals("cse")||query.equals("computer science")||
                    query.equals("Computer Science")||query.equals("Computer Science & Engineering")){
                    text = "Department of Computer Science and Engineering"
                }
                if(query.equals("EEE")||query.equals("eee")||query.equals("Electrical")||
                    query.equals("electrical")||query.equals("ELECTRICAL")||query.equals("Electrical Engineering")){
                    text = "Department of Electrical & Electronics Engineering"
                }
                if(query.equals("ME")||query.equals("me")||query.equals("Mechnical")||
                    query.equals("mechnical")||query.equals("MECHNICAL")||query.equals("Mechnical Engineering")){
                    text = "Department of Mechnical Engineering"
                }
                if(query.equals("civil")||query.equals("CIVIL")||query.equals("Civil Engineering")||
                    query.equals("CIVIL ENGINEERING")||query.equals("CE")||query.equals("ce")){
                    text = "Department of Civil Engineering"
                }

//                Toast.makeText(activity as Context , "onQuerySubmit",Toast.LENGTH_SHORT).show()
                displayList.clear()


                for(i in 0..facultyList.size-1) {
                    if (facultyList.get(i).department.equals(text) || subStr(facultyList.get(i).name,query) == true) {
                        displayList.add(facultyList.get(i))
                    } else {
                        // if query is not present we are displaying
                        // a toast message as no  data found..

                    }
                }
                    facultyAdapter.notifyDataSetChanged()
                    if(displayList.size<1) {
                        Toast.makeText(activity as Context, "No Matches found..", Toast.LENGTH_SHORT)
                           // .show()
                    }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                //listAdapter.filter.filter(newText)
              //  Toast.makeText(activity as Context , "onQuerryChange",Toast.LENGTH_SHORT).show()
                displayList.clear()
                for(i in 0..facultyList.size-1) {
                    if ( subStr(facultyList.get(i).department,newText)==true || subStr(facultyList.get(i).name,newText) == true) {
                        displayList.add(facultyList.get(i))
                    } else {
                        // if query is not present we are displaying
                        // a toast message as no  data found..

                    }
                }
                facultyAdapter.notifyDataSetChanged()
                return false
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        displayList.clear()
        //facultyList.clear()

    }



    fun subStr( name :   String?,str : String?): Boolean? {
        val result = name?.contains(""+str,ignoreCase = true)

        return result
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
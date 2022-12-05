package com.shashi.shashi_dce_desk.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.shashi_dce_desk.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [semesterSyllabusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class semesterSyllabusFragment : Fragment() {
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

    lateinit var title :TextView
    lateinit var semSyllabusView :WebView

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_semester_syllabus, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        semSyllabusView = view.findViewById(R.id.semSyllabusView)

        title = view.findViewById(R.id.sem_value)
        val value = arguments?.getString("branch_sem")
        title.text = value
        (activity as AppCompatActivity).supportActionBar?.title = "B.Tech"

        var url : String =""
        if(value.equals("CSE - I Sem")){
            url = "file:///android_asset/cse/cse1_st.html"
            semSyllabusView.settings.javaScriptEnabled = true

            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        //for cse 2nd sem
        if(value.equals("CSE - II Sem")){
            url = "file:///android_asset/cse/cse2.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        if(value.equals("CSE - III Sem")){
            url = "file:///android_asset/cse/cse3.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        if(value.equals("CSE - IV Sem")){
            url = "file:///android_asset/cse/cse4.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        if(value.equals("CSE - V Sem")){
            url = "file:///android_asset/cse/cse5.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        if(value.equals("CSE - VI Sem")){
            url = "file:///android_asset/cse/cse6.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }





        //Civil
        if(value.equals("Civil - I Sem")){
            url = "file:///android_asset/civil/ce1.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        if(value.equals("Civil - II Sem")){
            url = "file:///android_asset/civil/ce2.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        if(value.equals("Civil - III Sem")){
            url = "file:///android_asset/civil/ce3.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
        }

        if(value.equals("Civil - IV Sem")){
            url = "file:///android_asset/civil/ce4.html"
            semSyllabusView.settings.javaScriptEnabled = true
            semSyllabusView.settings.builtInZoomControls= true
            semSyllabusView.loadUrl(url)
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
         * @return A new instance of fragment semesterSyllabusFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            semesterSyllabusFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
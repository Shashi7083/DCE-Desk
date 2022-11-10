package com.example.shashi_DCE_HelpDesk.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.shashi_DCE_HelpDesk.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FacultyDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FacultyDetailsFragment : Fragment() {
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


    lateinit var txtname : TextView
    lateinit var txtdesignation : TextView
    lateinit var txtdepartment : TextView
    lateinit var txtwebsite : TextView
    lateinit var txtphone : TextView
    lateinit var txtemail : TextView
    lateinit var txtexperties : TextView
    lateinit var txttype : TextView
    lateinit var imgView : ImageView

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_faculty_details, container, false)



        val name : String? = arguments?.getString("name")
        Toast.makeText(activity as Context,name,Toast.LENGTH_LONG).show()
        val type : String? = arguments?.getString("type")
        val img : String? = arguments?.getString("img")
        val designation : String? = arguments?.getString("designation")
        val department : String? = arguments?.getString("department")
        val website : String? = arguments?.getString("website")
        val phone : String? = arguments?.getString("phone")
        val email : String? = arguments?.getString("email")
        val subject : String? = arguments?.getString("subject")


        txtname = view.findViewById(R.id.name)
        txtdesignation = view.findViewById(R.id.designation)
        txtdepartment = view.findViewById(R.id.department)
        txtemail = view.findViewById(R.id.email)
        txtphone = view.findViewById(R.id.email)
        txtexperties = view.findViewById(R.id.experties)
        txtwebsite = view.findViewById(R.id.website)
        txttype = view.findViewById(R.id.type)
        imgView = view.findViewById(R.id.imgfacultydetails)

        Picasso.get().load(img).error(R.drawable.faculty).into(imgView)

        txtname.text = name
        txtdesignation.text= designation
        txtdepartment.text = department
        txtphone.text = phone
        txtemail.text = email
        txtwebsite.text= website
        txtexperties.text = subject
        txttype.text = type

        if (type != null) {
            if (type.equals("Permanent") || type.equals("permanent") || type.equals("PERMANENT")) {
                txttype.setTextColor(R.color.green)
            }else if (type.equals("Guest") || type.equals("guest") || type.equals("GUEST")) {
                txttype.setTextColor(R.color.yellow)
            }
            else {
                txttype.setTextColor(R.color.red)
            }



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
         * @return A new instance of fragment FacultyDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FacultyDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
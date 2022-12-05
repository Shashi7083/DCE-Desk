package com.shashi.shashi_dce_desk.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shashi_dce_desk.R
import com.squareup.picasso.Picasso


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

    @SuppressLint("ResourceAsColor", "SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_faculty_details, container, false)



        val name : String? = arguments?.getString("name")

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
        txtphone = view.findViewById(R.id.phone)
        txtexperties = view.findViewById(R.id.experties)

       // val text = "<a href='http://www.google.com'> Google </a>"
        txtwebsite = view.findViewById(R.id.website)
        txttype = view.findViewById(R.id.type)
        imgView = view.findViewById(R.id.imgfacultydetails)

        imgView.setImageResource(R.drawable.faculty)

        if(img==null || img.equals("")){

        }else {
            Picasso.get().load(img).error(R.drawable.faculty).into(imgView)
        }

        var webLink = "<a href='"+website+"'>"+website+"</a>"
        var expert = "                                "+subject
        txtname.text = name
        txtdesignation.text= designation
        txtdepartment.text = department
        txtphone.text = phone
        txtemail.text = email
       // txtwebsite.text= webLink

        txtwebsite.setText(Html.fromHtml(webLink));
        txtexperties.text = expert
        txttype.text = type



     //   txttype.setTextColor(Color.parseColor("#F44336"))
            if (type.equals("Permanent") || type.equals("permanent") || type.equals("PERMANENT")) {
             txttype.setBackgroundResource(R.color.green)
                txttype.setTextColor(R.color.black)

            }else if (type.equals("Guest") || type.equals("guest") || type.equals("GUEST")) {
                txttype.setBackgroundResource(R.color.yellow)
            }
            else {
                txttype.setBackgroundResource(R.color.red)

            }

        txtemail.setOnClickListener {

            if (txtemail.text.equals("")) {

            } else {
                val intent = Intent(Intent.ACTION_SEND)
                val recipients = arrayOf(email)
                intent.putExtra(Intent.EXTRA_EMAIL, recipients)
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject text here...")
                intent.putExtra(Intent.EXTRA_TEXT, "Body of the content here...")
                intent.putExtra(Intent.EXTRA_CC, email)
                intent.type = "text/html"
                intent.setPackage("com.google.android.gm")
                startActivity(Intent.createChooser(intent, "Send mail"))
            }

        }



        txtphone.setOnClickListener {

            if (txtphone.text.equals("")) {

            } else {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:"+phone)
                startActivity(intent)
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
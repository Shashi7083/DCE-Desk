package com.example.shashi_DCE_HelpDesk.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.shashi_DCE_HelpDesk.R
import com.example.shashi_DCE_HelpDesk.R.id.medicalFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CounselingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounselingFragment : Fragment() {
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

    lateinit var imageView: ImageView
    lateinit var btnDocument :Button
    lateinit var documentsList :ImageView
    lateinit var btnMedicalFormat :Button
    lateinit var medical_format : ImageView
    lateinit var antiRagging : Button
    var visibledocs = false
    var visibleMedical = false
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_counseling, container, false)

        btnDocument = view.findViewById(R.id.btnDocument)
        documentsList = view.findViewById(R.id.documentsList)
        btnMedicalFormat = view.findViewById(medicalFormat)
        medical_format = view.findViewById(R.id.medical)
        antiRagging = view.findViewById(R.id.antiRagging)


        btnDocument.setOnClickListener {
            if(visibledocs == false){
                documentsList.visibility = View.VISIBLE
                visibledocs = true

                if(visibleMedical == true){
                    visibleMedical = false
                    medical_format.visibility = View.GONE
                }
            }
            else{
                documentsList.visibility = View.GONE
                visibledocs = false
            }

        }

        btnMedicalFormat.setOnClickListener {
            if(visibleMedical == false){
                medical_format.visibility = View.VISIBLE
                visibleMedical = true

                if(visibledocs == true){
                    visibledocs = false
                    documentsList.visibility = View.GONE
                }
            }
            else{
                medical_format.visibility = View.GONE
                visibleMedical = false
            }
        }

        antiRagging.setOnClickListener {
            Toast.makeText(activity , "Available Soon",Toast.LENGTH_SHORT).show()

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
         * @return A new instance of fragment CounselingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CounselingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
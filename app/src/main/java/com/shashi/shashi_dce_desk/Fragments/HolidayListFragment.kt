package com.shashi.shashi_dce_desk.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import com.example.shashi_dce_desk.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HolidayListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HolidayListFragment : Fragment() {
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


    var janclick  = false
    var febclick =false
    var marclick =false
    var aprclick= false
    var mayclick = false
    var junclick = false
    var julclick = false
    var augclick = false
    var sepclick = false
    var octclick = false
    var novclick = false
    var decclick = false

   lateinit var btnjan: Button
   lateinit var btnfeb :Button
    lateinit var btnmar :Button
    lateinit var btnapr :Button
    lateinit var btnmay :Button
    lateinit var btnjune :Button
    lateinit var btnjuly :Button
    lateinit var btnaug :Button
    lateinit var btnsep :Button
    lateinit var btnoct :Button
    lateinit var btnnov :Button
    lateinit var btndec :Button

    lateinit var txtjan :TextView
    lateinit var txtfeb :TextView
    lateinit var txtmar :TextView
    lateinit var txtapr :TextView
    lateinit var txtmay :TextView
    lateinit var txtjune :TextView
    lateinit var txtjuly :TextView
    lateinit var txtaug :TextView
    lateinit var txtsep :TextView
    lateinit var txtoct :TextView
    lateinit var txtnov :TextView
    lateinit var txtdec :TextView

    lateinit var holidayscroll :ScrollView


    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_holiday_list, container, false)

        btnjan = view.findViewById(R.id.btnJan)
        btnfeb = view.findViewById(R.id.btnfeb)
        btnmar = view.findViewById(R.id.btnmar)
        btnapr = view.findViewById(R.id.btnapr)
        btnmay = view.findViewById(R.id.btnmay)
        btnjune = view.findViewById(R.id.btnjun)
        btnjuly = view.findViewById(R.id.btnjul)
        btnaug = view.findViewById(R.id.btnaug)
        btnsep = view.findViewById(R.id.btnsep)
        btnoct = view.findViewById(R.id.btnoct)
        btnnov = view.findViewById(R.id.btnnov)
        btndec = view.findViewById(R.id.btndec)




        txtjan = view.findViewById(R.id.txtJan)
        txtfeb = view.findViewById(R.id.txtfeb)
        txtmar = view.findViewById(R.id.txtmar)
        txtapr= view.findViewById(R.id.txtapr)
        txtmay = view.findViewById(R.id.txtmay)
        txtjune = view.findViewById(R.id.txtjun)
        txtjuly = view.findViewById(R.id.txtjul)
        txtaug = view.findViewById(R.id.txtaug)
        txtsep = view.findViewById(R.id.txtsep)
        txtoct = view.findViewById(R.id.txtoct)
        txtnov = view.findViewById(R.id.txtnov)
        txtdec = view.findViewById(R.id.txtdec)

        holidayscroll = view.findViewById(R.id.holidayscroll)


        btnjan.setOnClickListener {

            if(janclick){
                janclick = false
                txtjan.visibility = View.GONE
            }
            else{
                janclick = true
                txtjan.visibility = View.VISIBLE
            }
        }

        btnfeb.setOnClickListener {

            if(febclick){
                febclick = false
                txtfeb.visibility = View.GONE
            }
            else{
                febclick = true
                txtfeb.visibility = View.VISIBLE
            }
        }

        btnmar.setOnClickListener {

            if(marclick){
                marclick = false
                txtmar.visibility = View.GONE
            }
            else{
                marclick = true
                txtmar.visibility = View.VISIBLE
            }
        }

        btnapr.setOnClickListener {

            if(aprclick){
                aprclick = false
                txtapr.visibility = View.GONE
            }
            else{
                aprclick = true
                txtapr.visibility = View.VISIBLE
            }
        }

        btnmay.setOnClickListener {

            if(mayclick){
                mayclick = false
                txtmay.visibility = View.GONE
            }
            else{
                mayclick = true
                txtmay.visibility = View.VISIBLE
            }
        }

        btnjune.setOnClickListener {

            if(junclick){
                junclick = false
                txtjune.visibility = View.GONE
            }
            else{
                junclick = true
                txtjune.visibility = View.VISIBLE
            }
        }

        btnjuly.setOnClickListener {

            if(julclick){
                julclick = false
                txtjuly.visibility = View.GONE
            }
            else{
                julclick = true
                txtjuly.visibility = View.VISIBLE
            }
        }

        btnaug.setOnClickListener {

            if(augclick){
                augclick = false
                txtaug.visibility = View.GONE
            }
            else{
                augclick = true
                txtaug.visibility = View.VISIBLE
            }
        }

        btnsep.setOnClickListener {

            if(sepclick){
                sepclick = false
                txtsep.visibility = View.GONE
            }
            else{
                sepclick = true
                txtsep.visibility = View.VISIBLE
            }
        }

        btnoct.setOnClickListener {

            if(octclick){
                octclick = false
                txtoct.visibility = View.GONE
            }
            else{
                octclick = true
                txtoct.visibility = View.VISIBLE
               // holidayscroll.fullScroll(View.FOCUS_DOWN)
            }
        }

        btnnov.setOnClickListener {

            if(novclick){
                novclick = false
                txtnov.visibility = View.GONE
            }
            else{
                novclick = true
                txtnov.visibility = View.VISIBLE
               // holidayscroll.fullScroll(View.FOCUS_DOWN)
            }
        }

        btndec.setOnClickListener {

            if(decclick){
                decclick = false
                txtdec.visibility = View.GONE
                val param = btndec.layoutParams as ViewGroup.MarginLayoutParams
                param.setMargins(40,10,40,80)
                btndec.layoutParams=param
            }
            else{
                decclick = true
                val param = btndec.layoutParams as ViewGroup.MarginLayoutParams
                param.setMargins(40,10,40,8)
                btndec.layoutParams=param
                txtdec.visibility = View.VISIBLE
                holidayscroll.fullScroll(View.FOCUS_DOWN)
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
         * @return A new instance of fragment HolidayListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HolidayListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
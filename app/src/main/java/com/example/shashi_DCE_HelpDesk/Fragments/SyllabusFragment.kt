package com.example.shashi_DCE_HelpDesk.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.shashi_DCE_HelpDesk.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SyllabusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SyllabusFragment : Fragment() {
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

    lateinit var cseConst :ConstraintLayout
    lateinit var civilConst : ConstraintLayout
    lateinit var meConst : ConstraintLayout
    lateinit var  eeeConst :ConstraintLayout
    lateinit var txtTop : TextView
    lateinit var branchLinearLayout :LinearLayout
    lateinit var semesters :LinearLayout

    lateinit var firstSem :ConstraintLayout
    lateinit var secondSem : ConstraintLayout
    lateinit var thirdSem : ConstraintLayout
    lateinit var  fourthSem :ConstraintLayout
    lateinit var fifthSem :ConstraintLayout
    lateinit var sixthSem : ConstraintLayout
    lateinit var seventhSem : ConstraintLayout
    lateinit var  eighthSem :ConstraintLayout

    var selectedBranch : String = ""
    var selectedSemester : String =""

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_syllabus, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "B.Tech"

        cseConst = view.findViewById(R.id.CSEBranch)
        civilConst = view.findViewById(R.id.CivilBranch)
        meConst = view.findViewById(R.id.MEBranch)
        eeeConst = view.findViewById(R.id.EEEBranch)
        txtTop = view.findViewById(R.id.txt)
        branchLinearLayout = view.findViewById(R.id.branchList)
        semesters = view.findViewById(R.id.semesters)

        firstSem= view.findViewById(R.id.firstSem)
        secondSem=view.findViewById(R.id.secondSem)
        thirdSem = view.findViewById(R.id.thirdSem)
        fourthSem = view.findViewById(R.id.fourthSem)
        fifthSem = view.findViewById(R.id.fifthSem)
        sixthSem = view.findViewById(R.id.sixthSem)
        seventhSem = view.findViewById(R.id.seventhSem)
        eighthSem = view.findViewById(R.id.eigthSem)

        //To know which branch user select
     cseConst.setOnClickListener {
         selectedBranch = "CSE"
         txtTop.text = selectedBranch
         branchLinearLayout.visibility = View.GONE
         semesters.visibility = View.VISIBLE

         //giving background to sem

             firstSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))
         secondSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))
         thirdSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))
         fourthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))
         fifthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))
         sixthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))
         seventhSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))
         eighthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_green))



     }

        civilConst.setOnClickListener {
            selectedBranch = "Civil"
            txtTop.text = selectedBranch
            branchLinearLayout.visibility = View.GONE
            semesters.visibility = View.VISIBLE

            firstSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
            secondSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
            thirdSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
            fourthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
            fifthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
            sixthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
            seventhSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
            eighthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_sky))
        }

        meConst.setOnClickListener {
            selectedBranch = "ME"
            txtTop.text = selectedBranch
            branchLinearLayout.visibility = View.GONE
            semesters.visibility = View.VISIBLE

            firstSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
            secondSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
            thirdSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
            fourthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
            fifthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
            sixthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
            seventhSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
            eighthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_violet))
        }

        eeeConst.setOnClickListener {
            selectedBranch = "EEE"
            txtTop.text = selectedBranch
            branchLinearLayout.visibility = View.GONE
            semesters.visibility = View.VISIBLE

            firstSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
            secondSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
            thirdSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
            fourthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
            fifthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
            sixthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
            seventhSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
            eighthSem.setBackground(ContextCompat.getDrawable(activity as Context , R.drawable.glow_bk_blue))
        }




        firstSem.setOnClickListener {
            selectedSemester = "I Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

        }


        secondSem.setOnClickListener {
            selectedSemester = "II Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

        }

        thirdSem.setOnClickListener {
            selectedSemester = "III Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

        }

        fourthSem.setOnClickListener {
            selectedSemester = "IV Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

        }

        fifthSem.setOnClickListener {
            selectedSemester = "V Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

        }

        sixthSem.setOnClickListener {
            selectedSemester = "VI Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

        }

        seventhSem.setOnClickListener {
            selectedSemester = "VII Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

        }

        eighthSem.setOnClickListener {
            selectedSemester = "VIII Sem"
            //semesters.visibility = View.GONE

            val semesterFragment = semesterSyllabusFragment()
            val bundle = Bundle()
            bundle.putString("branch_sem",selectedBranch+" - "+selectedSemester)
            semesterFragment.arguments=bundle
            getFragmentManager()?.beginTransaction()?.addToBackStack(null)?.add(R.id.frameLayout, semesterFragment)?.commit();

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
         * @return A new instance of fragment SyllabusFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SyllabusFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
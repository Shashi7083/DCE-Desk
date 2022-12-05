package com.shashi.shashi_dce_desk.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

import com.example.shashi_dce_desk.R
import com.shashi.shashi_dce_desk.Fragments.FacultyDetailsFragment
import com.shashi.shashi_dce_desk.Model.FacultyModel
import com.squareup.picasso.Picasso

class FacultyAdapter(val context : Context, val facultyList : ArrayList<FacultyModel>) : RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.faculty_view_details,parent,false)
        return FacultyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {

        val faculty = facultyList.get(position)

        holder.facultyName.text = faculty.name
        holder.facultyDesignation.text = faculty.designation
        holder.facultyDepartment.text = faculty.department

        //Picasso.get().load("faculty.img").error(R.drawable.toolbackground).into(holder.facultyImg)

        if((faculty.img == null) || (faculty.img == "N/A") || (faculty.img.equals(""))){
            holder.facultyImg.setImageResource(R.drawable.faculty)
        }else {
            Picasso.get().load(faculty.img).error(R.drawable.faculty).into(holder.facultyImg)
        }


        holder.facultyContent.setOnClickListener {

            var args : Bundle = Bundle()
            args.putString("sno",faculty.sno)
            args.putString("type",faculty.type)
            args.putString("name",faculty.name)
            args.putString("img",faculty.img)
            args.putString("designation",faculty.designation)
            args.putString("department",faculty.department)
            args.putString("website",faculty.web_url)
            args.putString("phone",faculty.phone)
            args.putString("email",faculty.email)
            args.putString("subject",faculty.subject_experties)

            val fragmentManager :FragmentManager = (context as FragmentActivity).supportFragmentManager
            val fragmentTransaction :FragmentTransaction = fragmentManager.beginTransaction()
            val  fragment = FacultyDetailsFragment()
            fragment.arguments=args
            fragmentTransaction.replace(R.id.frameLayout,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }



    }

    override fun getItemCount(): Int {

        return facultyList.size
    }


    class FacultyViewHolder(view : View): RecyclerView.ViewHolder(view){
        val facultyImg = view.findViewById<ImageView>(R.id.facultyImg)
        val facultyName = view.findViewById<TextView>(R.id.facultyName)
        val facultyDesignation = view.findViewById<TextView>(R.id.facultyDesignation)
        val facultyDepartment = view.findViewById<TextView>(R.id.facultyDepartment)
        val facultyContent = view.findViewById<CardView>(R.id.facultyContent)
    }
}
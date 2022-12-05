package com.shashi.shashi_dce_desk.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shashi_dce_desk.R
import com.shashi.shashi_dce_desk.Model.PlacementModel
import com.squareup.picasso.Picasso


class PlacementAdapter(val context : Context, val list : ArrayList<PlacementModel>) :RecyclerView.Adapter<PlacementAdapter.PlacementViewHolder>(){




    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacementViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.placement_list,parent,false)

        return PlacementViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlacementViewHolder, position: Int) {

        val student = list.get(position)
        holder.stBatch.text = student.batch
        holder.stBranch.text = student.branch
        holder.stName.text = student.name
        holder.stCompany.text = student.company
        holder.stLPA.text = student.lpa

        if((student.img == null) || (student.img == "N/A") || (student.img.equals(""))){
            holder.stImg.setImageResource(R.drawable.faculty)
        }else {
            Picasso.get().load(student.img).error(R.drawable.faculty).into(holder.stImg)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class PlacementViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val stName :TextView = view.findViewById(R.id.stName)
        val stBranch : TextView = view.findViewById(R.id.stbranch)
        val stBatch : TextView = view.findViewById(R.id.stbatch)
        val stCompany : TextView = view.findViewById(R.id.company)
        val stLPA : TextView = view.findViewById(R.id.lpa)
        val stImg : de.hdodenhof.circleimageview.CircleImageView = view.findViewById(R.id.stimg)
    }

}
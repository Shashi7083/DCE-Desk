package com.example.shashi_DCE_HelpDesk.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shashi_DCE_HelpDesk.Model.RoomModel
import com.example.shashi_DCE_HelpDesk.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class RoomAdapter(val context: Context, val roomList :ArrayList<RoomModel>): RecyclerView.Adapter<RoomAdapter.roomViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): roomViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.room_view_details,parent,false)
        return roomViewHolder(view)
    }

    override fun onBindViewHolder(holder: roomViewHolder, position: Int) {

        var room = roomList.get(position)
        holder.address.text = room.locAddress
        holder.landmark.text = room.landMark
        holder.roomType.text = room.For
        holder.rent.text = room.rent

        if(room.img ==null || room.img ==""){
            holder.roomImage.setImageResource(R.drawable.animehousepng)
        }else {
            Picasso.get().load(room.img).error(R.drawable.animehousepng).into(holder.roomImage)
        }



        holder.location.setOnClickListener {
            Toast.makeText(context,"Feature not available",Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
      return roomList.size
    }

    class roomViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val roomImage= view.findViewById<ImageView>(R.id.imgRoom)
        val landmark = view.findViewById<TextView>(R.id.locationLandmark)
        val address = view.findViewById<TextView>(R.id.locationAddress)
        val roomType = view.findViewById<TextView>(R.id.roomType)
        val rent = view.findViewById<TextView>(R.id.roomPrice)
        val location = view.findViewById<ImageView>(R.id.location)

    }
}
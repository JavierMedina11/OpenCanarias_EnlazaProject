package com.opencanarias.frontend.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opencanarias.frontend.R
import com.opencanarias.frontend.models.Room
import com.squareup.picasso.Picasso

class RoomAdapter(var roomList: ArrayList<Room>, val context: Context): RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_container_rooms, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(roomList[position], context)
    }

    override fun getItemCount(): Int {
        return roomList.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(b: Room, context: Context){
            val url = "http://192.168.56.1:8000/img/"
            val kbvLocation: ImageView = itemView.findViewById(R.id.kbvLocation)
            val textName: TextView = itemView.findViewById(R.id.textTitle)
            val textSubname: TextView = itemView.findViewById(R.id.textLocation)
            val textStar: TextView = itemView.findViewById(R.id.textStarRating)

            val imageUrl = url + b.urlimg1 + ".png"
            Picasso.with(context).load(imageUrl).into(kbvLocation);

            textName.text = b.subname
            textSubname.text = b.name
            textStar.text = b.starRating.toString()

            itemView.setOnClickListener {
                val intent = Intent(context, RoomDetailActivity::class.java)
                intent.putExtra("roomId", b.id)
                intent.putExtra("state", "Showing")
                Log.v("hola caracola antes", b.id.toString())
                context.startActivity(intent)
            }
        }
    }

}

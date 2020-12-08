package com.opencanarias.frontend.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opencanarias.frontend.R
import com.opencanarias.frontend.models.Room
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


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
            val kbvLocation: TextView = itemView.findViewById(R.id.kbvLocation)
            val textTitle: TextView = itemView.findViewById(R.id.textTitle)
            val textLocation: TextView = itemView.findViewById(R.id.textLocation)
            val textStar: TextView = itemView.findViewById(R.id.textStarRating)

            Picasso.with(context).load(b.imageUrl).into(kbvLocation);

            textTitle.text = b.title
            textLocation.text = b.location
            textStar.text = b.starRating.toString()
        }
    }

}

private fun RequestCreator.into(kbvLocation: TextView) {

}

package com.opencanarias.frontend.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.ServiceImpl
import com.opencanarias.frontend.models.Booking

class UserAdapter(var bookingList: ArrayList<Booking>, val context: Context): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_container_booking, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(bookingList[position], context)
    }

    override fun getItemCount(): Int {
        return bookingList.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(b: Booking, context: Context){
            val kbv: ImageView = itemView.findViewById(R.id.kbvLocation)
            val textName: TextView = itemView.findViewById(R.id.textTitle)
            val textSubname: TextView = itemView.findViewById(R.id.textLocation)
            val textStar: TextView = itemView.findViewById(R.id.textStarRating)
            val deleteButton: LinearLayout = itemView.findViewById(R.id.deleteReserv)

            textName.text = b.check_in
            textSubname.text = b.check_out
            textStar.text = b.diet

            kbv.setOnClickListener{
                val intent = Intent(context, UpdateReservationActivity::class.java)
                intent.putExtra("bookingId", b.id)
                intent.putExtra("bookingCheckIn", b.check_in)
                intent.putExtra("bookingCheckOut", b.check_out)
                intent.putExtra("bookingDiet", b.diet)
                intent.putExtra("bookingUserId", b.id_user)
                intent.putExtra("bookingRoomId", b.id_room)
                context.startActivity(intent)
            }

            deleteButton.setOnClickListener {
                val bicycleServiceImpl = ServiceImpl()
                bicycleServiceImpl.deleteById(context, b.id) { ->
                    run {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }

}

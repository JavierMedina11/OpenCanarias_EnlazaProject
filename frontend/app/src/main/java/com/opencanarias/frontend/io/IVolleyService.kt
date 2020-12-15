package com.opencanarias.frontend.io

import android.content.Context
import com.opencanarias.frontend.models.Booking
import com.opencanarias.frontend.models.Room
import com.opencanarias.frontend.models.User

interface IVolleyService {

    fun getAll(context: Context, completionHandler: (response: ArrayList<Room>?) -> Unit)

    fun getBooking(context: Context, userId: Int, completionHandler: (response: ArrayList<Booking>?) -> Unit)

    fun getBookings(context: Context, completionHandler: (response: ArrayList<Booking>?) -> Unit)

    fun getById(context: Context, bicycleId: Int, completionHandler: (response: Room?) -> Unit)

    fun registerUser(context: Context, user: User, completionHandler: () -> Unit)

    fun getByIdUser(context: Context, userId: Int, completionHandler: (response: User?) -> Unit)

    fun generateReserve(context: Context, booking: Booking, completionHandler: () -> Unit)

    fun deleteById(context: Context, roomId: Int, completionHandler: () -> Unit)

    fun deleteByIdUser(context: Context, roomId: Int, completionHandler: () -> Unit)

    fun updateReserve(context: Context,  booking: Booking, completionHandler: () -> Unit)

    fun updateUser(context: Context,  user: User, completionHandler: () -> Unit)

}
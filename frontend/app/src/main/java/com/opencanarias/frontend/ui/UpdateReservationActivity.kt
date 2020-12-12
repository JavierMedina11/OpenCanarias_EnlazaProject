package com.opencanarias.frontend.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import com.opencanarias.frontend.R
import com.opencanarias.frontend.io.ServiceImpl
import com.opencanarias.frontend.models.Booking
import com.retrofitP.loginimplementation.util.PreferenceHelper
import com.retrofitP.loginimplementation.util.PreferenceHelper.set
import kotlinx.android.synthetic.main.activity_reservation.*
import kotlinx.android.synthetic.main.activity_update_reservation.*
import kotlinx.android.synthetic.main.activity_update_reservation.groupRadio
import kotlinx.android.synthetic.main.activity_update_reservation.radioButton
import kotlinx.android.synthetic.main.activity_update_reservation.radioButton2

class UpdateReservationActivity : AppCompatActivity() {

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private val select: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.N)
    private val select2: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_reservation)

        val bookingId = this.intent.getIntExtra("bookingId", 1)
        val bookingUserId = this.intent.getIntExtra("bookingUserId", 1)
        val bookingIdRoom = this.intent.getIntExtra("bookingRoomId", 1)
        val dietValue = preferences.getString("dietValue", "Full Pension").toString()

        groupRadio.clearCheck()
        groupRadio.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (radioButton.isChecked){
                preferences["dietValue"] = "Full Pension";
                radioButton2.isChecked = false
            }else if (radioButton2.isChecked){
                preferences["dietValue"] = "Half Pension";
                radioButton.isChecked = false
            }
        })
        updateButton.setOnClickListener {
            val booking = Booking(bookingId, updateDate.text.toString(), updateDate2.text.toString(), dietValue, bookingUserId, bookingIdRoom)
            updateBooking(booking)
        }
    }

    private fun updateBooking(booking: Booking) {
        val bookingServiceImpl = ServiceImpl()
        bookingServiceImpl.updateReserve(this, booking) { ->
            run {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun onClickUpdateDate(v: View?){

        val year = select.get(Calendar.YEAR)
        val month = select.get(Calendar.MONTH)
        val dayOfMonth = select.get(Calendar.DAY_OF_MONTH)

        val listener = DatePickerDialog.OnDateSetListener{ datePicker, y, m, d ->
            select.set(y, m, d)
            updateDate.setText(resources.getString(R.string.date_format, y, (m+1).twoDigits(), d.twoDigits()))
        }

        // new dialog
        val datePickerDialog = DatePickerDialog(this, listener, year, month, dayOfMonth)
        val datePicker = datePickerDialog.datePicker

        // set limits
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        datePicker.minDate = select.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH, 29)
        datePicker.maxDate = calendar.timeInMillis

        // show dialog
        datePickerDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun onClickUpdateDate2(v: View?){

        val year = select2.get(Calendar.YEAR)
        val month = select2.get(Calendar.MONTH)
        val dayOfMonth = select2.get(Calendar.DAY_OF_MONTH)

        val listener = DatePickerDialog.OnDateSetListener{ datePicker, y, m, d ->
            select2.set(y, m, d)
            updateDate2.setText(resources.getString(R.string.date_format, y, (m+1).twoDigits(), d.twoDigits()))
        }

        // new dialog
        val datePickerDialog = DatePickerDialog(this, listener, year, month, dayOfMonth)
        val datePicker = datePickerDialog.datePicker

        // set limits
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        datePicker.minDate = select2.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH, 29)
        datePicker.maxDate = calendar.timeInMillis

        // show dialog
        datePickerDialog.show()
    }
    private fun Int.twoDigits()
            = if (this>=10) this.toString() else "0$this"

}
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
import kotlinx.android.synthetic.main.activity_user_profile.*

class ReservationActivity : AppCompatActivity() {

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private val selectedCalendar: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.N)
    private val selectedCalendar2: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val state = this.intent.getStringExtra("state").toString()
        val userId = preferences.getInt("userDNI", 1)
        val roomId = this.intent.getIntExtra("roomId", 1)
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

        createButton.setOnClickListener{
            val booking = Booking(10, reservationDate.text.toString(), reservationDate2.text.toString(), dietValue, userId, roomId)
            createReserve(booking)
        }
    }

    fun createReserve(booking: Booking){
        val serviceImpl = ServiceImpl()
        serviceImpl.generateReserve(this, booking) { ->
            run {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onClickSheduleDate(v: View?){

        val year = selectedCalendar.get(Calendar.YEAR)
        val month = selectedCalendar.get(Calendar.MONTH)
        val dayOfMonth = selectedCalendar.get(Calendar.DAY_OF_MONTH)

        val listener = DatePickerDialog.OnDateSetListener{ datePicker, y, m, d ->
            //Toast.makeText(this, "$y-$m-$d", Toast.LENGTH_SHORT).show()
            selectedCalendar.set(y, m, d)
            reservationDate.setText(resources.getString(R.string.date_format, y, (m+1).twoDigits(), d.twoDigits()))
        }

        // new dialog
        val datePickerDialog = DatePickerDialog(this, listener, year, month, dayOfMonth)
        val datePicker = datePickerDialog.datePicker

        // set limits
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        datePicker.minDate = selectedCalendar.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH, 29)
        datePicker.maxDate = calendar.timeInMillis

        // show dialog
        datePickerDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onClickSheduleDate2(v: View?){

        val year = selectedCalendar2.get(Calendar.YEAR)
        val month = selectedCalendar2.get(Calendar.MONTH)
        val dayOfMonth = selectedCalendar2.get(Calendar.DAY_OF_MONTH)

        val listener = DatePickerDialog.OnDateSetListener{ datePicker, y, m, d ->
            //Toast.makeText(this, "$y-$m-$d", Toast.LENGTH_SHORT).show()
            selectedCalendar2.set(y, m, d)
            reservationDate2.setText(resources.getString(R.string.date_format, y, (m+1).twoDigits(), d.twoDigits()))
        }

        // new dialog
        val datePickerDialog = DatePickerDialog(this, listener, year, month, dayOfMonth)
        val datePicker = datePickerDialog.datePicker

        // set limits
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        datePicker.minDate = selectedCalendar2.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH, 29)
        datePicker.maxDate = calendar.timeInMillis

        // show dialog
        datePickerDialog.show()
    }

    private fun Int.twoDigits()
            = if (this>=10) this.toString() else "0$this"
}
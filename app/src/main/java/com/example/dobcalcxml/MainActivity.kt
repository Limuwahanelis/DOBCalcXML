package com.example.dobcalcxml

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.temporal.ValueRange
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate :TextView?=null;
    private var tvAgeInMinutes :TextView?=null;
    private val myCalendar:Calendar = Calendar.getInstance();
    private val year:Int=myCalendar.get(Calendar.YEAR);
    private val month:Int = myCalendar.get(Calendar.MONTH);
    private val day:Int = myCalendar.get(Calendar.DAY_OF_MONTH)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker:Button=findViewById(R.id.buttonDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes);

        val selectedDate ="$day/${month+1}/$year";
        tvSelectedDate?.text = selectedDate;


        btnDatePicker.setOnClickListener { clickDatePicker()}
    }

    private fun clickDatePicker()
    {

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _,year,month,dayOfMonth->
                val selectedDate ="$dayOfMonth/${month+1}/$year";
                tvSelectedDate?.text = selectedDate;

                val sdf:SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate:Date? = sdf.parse(selectedDate);
                theDate?.let{
                    val selectedDateInMinutes:Long= theDate.time/60000;
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))// get time in milliseconds since 1970
                    currentDate?.let {
                        val currentDateInMinutes:Long = currentDate.time/60000;
                        val differenceInMinutes:Long = currentDateInMinutes - selectedDateInMinutes;
                        tvAgeInMinutes?.text=differenceInMinutes.toString();
                    }

                }

            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000;// 86400000 milliseconds in one hour
        dpd.show();
        //Toast.makeText(this,"button pressed",Toast.LENGTH_LONG).show()
    }


}
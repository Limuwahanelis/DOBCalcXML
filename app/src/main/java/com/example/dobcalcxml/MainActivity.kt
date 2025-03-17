package com.example.dobcalcxml

import android.app.DatePickerDialog
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
    private val myCalendar:Calendar = Calendar.getInstance();
    private val year:Int=myCalendar.get(Calendar.YEAR);
    private val month:Int = myCalendar.get(Calendar.MONTH);
    private val day:Int = myCalendar.get(Calendar.DAY_OF_MONTH)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker:Button=findViewById(R.id.buttonDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate);

        val selectedDate ="$day/${month+1}/$year";
        tvSelectedDate?.text = selectedDate;


        btnDatePicker.setOnClickListener { clickDatePicker()}
    }

    fun clickDatePicker()
    {

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view,year,month,dayOfMonth->
                Toast.makeText(this,"Date picker works",Toast.LENGTH_LONG).show();
                val selectedDate ="$dayOfMonth/${month+1}/$year";
                tvSelectedDate?.text = selectedDate;

                val sdf:SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate:Date? = sdf.parse(selectedDate);

            },
            year,
            month,
            day).show();

        //Toast.makeText(this,"button pressed",Toast.LENGTH_LONG).show()
    }


}
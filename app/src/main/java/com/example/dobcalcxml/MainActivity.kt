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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker:Button=findViewById(R.id.buttonDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate);

        btnDatePicker.setOnClickListener { clickDatePicker()}
    }

    fun clickDatePicker()
    {
        val myCalendar:Calendar = Calendar.getInstance();
        val year:Int=myCalendar.get(Calendar.YEAR);
        val month:Int = myCalendar.get(Calendar.MONTH);
        val day:Int = myCalendar.get(Calendar.DAY_OF_MONTH)
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
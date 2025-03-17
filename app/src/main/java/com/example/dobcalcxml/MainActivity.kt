package com.example.dobcalcxml

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.time.temporal.ValueRange
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker:Button=findViewById(R.id.buttonDatePicker)
        btnDatePicker.setOnClickListener { clickDatePicker()}
    }

    fun clickDatePicker()
    {
        val myCalendar = Calendar.getInstance();
        val year=myCalendar.get(Calendar.YEAR);
        val month = myCalendar.get(Calendar.MONTH);
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view,year,month,dayOfMonth->
                Toast.makeText(this,"Date picker works",Toast.LENGTH_LONG).show()
            },
            year,
            month,
            day).show();

        //Toast.makeText(this,"button pressed",Toast.LENGTH_LONG).show()
    }


}
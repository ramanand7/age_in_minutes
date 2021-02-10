package com.example.ageinminutess

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var butt: Button  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          butt = findViewById(R.id.selectdatebutton)

        butt.setOnClickListener{view->
            clickdatepicker(view)

        }




    }
    @SuppressLint("NewApi")
    fun clickdatepicker(view : View){

        val mycalender = Calendar.getInstance();
        val year = mycalender.get(Calendar.YEAR)
        val month = mycalender.get(Calendar.MONTH)
        val date = mycalender.get(Calendar.DATE)

       val dat= DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->



                val selected_date = "$year/${month+1}/$dayOfMonth"
                findViewById<TextView>(R.id.selected_date).setText(selected_date)

                val sdf = SimpleDateFormat("dd/mm/yyyy",Locale.ENGLISH)
                val thedate = sdf.parse(selected_date)

                val selectedateinminutes = thedate!!.time/60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentdatetominutes = currentDate!!.time /60000

                val differenceinminutes = currentdatetominutes -selectedateinminutes

                findViewById<TextView>(R.id.selected_dateinminutes).setText(differenceinminutes.toString())


        }
            ,year,month,date)

        dat.datePicker.setMaxDate(Date().time-86400000)
        dat.show()
    }

}
package com.lionos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_calendar
        )

        val dateText =
            findViewById<TextView>(
                R.id.dateText
            )
            
        val dayText =
           findViewById<TextView>(
                R.id.dayText
              )

        val format =
            SimpleDateFormat(
                "dd MMMM yyyy",
                Locale.getDefault()
            )

        dateText.text =
            format.format(Date())
            
            
            val dayFormat =
    SimpleDateFormat(
        "EEEE",
        Locale.getDefault()
    )

dayText.text =
    dayFormat.format(Date())
    }
}
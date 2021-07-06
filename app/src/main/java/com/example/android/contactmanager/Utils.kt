package com.example.android.contactmanager

import android.app.DatePickerDialog
import android.widget.EditText
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private val df = SimpleDateFormat("dd/MM/yy", Locale.US)

fun String.toDateOrToday(): Date = try {
    df.parse(this) ?: Date()
} catch (e: ParseException) {
    Date()
}

fun Calendar.toFormattedString(): String = df.format(time)

fun String.toCalendar(): Calendar = Calendar.getInstance().apply {
    time = toDateOrToday()
}

fun showDatePickerDialog(editText: EditText) {
    val listener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        val cal = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, monthOfYear)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }
        editText.setText(cal.toFormattedString())
    }

    val cal = editText.text.toString().toCalendar()
    DatePickerDialog(
        editText.context,
        listener,
        cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH),
        cal.get(Calendar.DAY_OF_MONTH)
    ).show()
}
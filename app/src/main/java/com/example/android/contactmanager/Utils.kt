package com.example.android.contactmanager

import android.app.DatePickerDialog
import android.widget.EditText
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val CONTACT_ID = "extra_contact_id"
const val CONTACT_FIRST_NAME = "extra_contact_first_name"
const val CONTACT_LAST_NAME = "extra_contact_last_name"
const val CONTACT_PHONE_NUMBER = "extra_contact_phone_number"
const val CONTACT_ADDRESS = "extra_contact_address"
const val CONTACT_BIRTHDAY = "extra_contact_birthday"
const val CONTACT_ZIP_CODE = "extra_contact_zip_code"

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
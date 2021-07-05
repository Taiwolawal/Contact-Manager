package com.example.android.contactmanager

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.contactmanager.databinding.ActivityContactDetailBinding
import com.example.android.contactmanager.db.Contact
import java.util.*

class ContactDetail : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailBinding
    private lateinit var contactDetail: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.etBirthday.setOnClickListener {
            setDate()
        }

        binding.checkButton.setOnClickListener {
            val firstName =binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val phoneNumber = binding.etPhoneNumber.text.toString().toIntOrNull()
            val address = binding.etAddress.text.toString()
            val zipCode = binding.etZipCode.text.toString().toInt()
            contactDetail = Contact(id=0, firstName,lastName, phoneNumber,address, zipCode)

            if(firstName == "" || lastName == ""|| phoneNumber == 0 || address == "" || zipCode == 0 ){
                Toast.makeText(this,"Fill in the blank form", Toast.LENGTH_SHORT ).show()
            } else {

            }


        }
        saveContact()

    }

     fun saveContact() {

    }

    private fun setDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this, { view, year, month, dayOfMonth ->
                val returnDate = "$dayOfMonth  ${month + 1}  $year "

                val date = StringHelper.parseDate(
                    "dd MM yy" ,
                    "dd/MM/yy",
                    returnDate
                )
                binding.etBirthday.setText(StringHelper.parseDate("MM/dd/yy", "dd/MM/yy", date))
                binding.etBirthday.error = null
            }, year-71, month, day
        )
        dpd.show()

//        this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//                val returnDate = "${month + 1}  $dayOfMonth $year"
//                val date = StringHelper.parseDate(
//                    "MM dd yyyy" ,
//                    "MM/dd/yyyy",
//                    returnDate
//                )
//                binding.etBirthday.setText(StringHelper.parseDate("MM/dd/yyyy", "MMM dd yyyy", date))
//                binding.etBirthday.error = null
//            }, year-100, month, day


    }
}
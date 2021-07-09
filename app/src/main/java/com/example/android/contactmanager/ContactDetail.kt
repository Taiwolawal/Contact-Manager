package com.example.android.contactmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.contactmanager.databinding.ActivityContactDetailBinding
import com.example.android.contactmanager.db.Contact
import com.google.android.material.snackbar.Snackbar
import java.util.*

class ContactDetail : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailBinding
    private lateinit var contactDetail: Contact
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etBirthday.setOnClickListener {
            showDatePickerDialog(binding.etBirthday)
        }

        binding.checkButton.setOnClickListener {
            saveContact()
            finish()
        }

    }

    private fun saveContact() {
        val firstName = (binding.etFirstName.text.toString()).capitalize(Locale.ROOT)
        val lastName = (binding.etLastName.text.toString()).capitalize(Locale.ROOT)
        val birthday = binding.etBirthday.text.toString()
        val phoneNumber = binding.etNumber.text.toString()
        val address = binding.etAddress.text.toString()
        val zipCode = binding.etZipCode.text.toString()
        contactDetail = Contact(id = 0, firstName, lastName, phoneNumber,birthday, address, zipCode)

        if (firstName == "" || lastName == "" || phoneNumber == "" || address == "" || zipCode == "") {
            Snackbar.make(binding.contactDetailLayout, R.string.fill_blank, Snackbar.LENGTH_LONG).show()
        } else {
            viewModel.saveContact(contactDetail)
            Snackbar.make(binding.contactDetailLayout, R.string.contact_added, Snackbar.LENGTH_LONG).show()
        }
    }


}
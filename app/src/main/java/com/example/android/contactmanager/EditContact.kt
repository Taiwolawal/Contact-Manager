package com.example.android.contactmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.contactmanager.databinding.ActivityEditContactBinding


class EditContact : AppCompatActivity() {


    private var contactId = 0
    private var contactFirstName = ""
    private var contactLastName = ""
    private var contactAddress = ""
    private var contactPhoneNumber = ""
    private var contactZipCode = ""
    private var contactBirthday = 0

    private lateinit var binding: ActivityEditContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            showContact(extras)
        } else {
            finish()
        }

        saveContact()
        deleteContact()

    }

    private fun deleteContact() {
        TODO("Not yet implemented")
    }

    private fun saveContact() {
        TODO("Not yet implemented")
    }

    private fun showContact(extras: Bundle) {
        contactId = extras.getInt(CONTACT_ID)
        contactFirstName = extras.getString(CONTACT_FIRST_NAME, "")
        contactLastName = extras.getString(CONTACT_LAST_NAME, "")
        contactAddress = extras.getString(CONTACT_ADDRESS, "")
        contactPhoneNumber = extras.getString(CONTACT_PHONE_NUMBER, "")
        contactZipCode = extras.getString(CONTACT_ZIP_CODE, "")

        binding.editFirstName.text?.append(contactFirstName.subSequence(0,contactFirstName.lastIndex))
        binding.editLastName.text?.append(contactLastName.subSequence(0,contactLastName.lastIndex))
        binding.editPhoneNumber.text?.append(contactPhoneNumber.subSequence(0,contactFirstName.lastIndex))
        binding.editLocation.text?.append(contactFirstName.subSequence(0,contactFirstName.lastIndex))
        binding.editZipCode.text?.append(contactZipCode)
//        binding.editBirthday.text?.append(contactFirstName)

    }
}
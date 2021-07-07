package com.example.android.contactmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.contactmanager.databinding.ActivityEditContactBinding


class EditContact : AppCompatActivity() {


    private var contactId = 0
    private var contactFirstName = ""
    private var contactLastName = ""
    private var contactAddress = ""
    private var contactPhoneNumber = 0
    private var contactZipCode = 0
    private var contactBirthday = 0

    private  lateinit var binding: ActivityEditContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        val extras = intent.extras
        if(extras != null){
            showContact(extras)
        } else{
            finish()
        }

    }

    private fun showContact(extras: Bundle) {
         contactId = extras.getInt(CONTACT_ID)
        contactFirstName = extras.getString(CONTACT_FIRST_NAME, "")
        contactLastName = extras.getString(CONTACT_LAST_NAME,"")
        contactAddress = extras.getString(CONTACT_ADDRESS, "")
        contactPhoneNumber = extras.getInt(CONTACT_PHONE_NUMBER, 0)
        contactZipCode = extras.getInt(CONTACT_ZIP_CODE, 0)



        binding.apply {

        }

    }
}
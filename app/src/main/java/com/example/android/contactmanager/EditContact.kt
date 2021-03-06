package com.example.android.contactmanager

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android.contactmanager.databinding.ActivityEditContactBinding
import com.example.android.contactmanager.db.Contact
import com.google.android.material.snackbar.Snackbar
import java.util.*


class EditContact : AppCompatActivity() {


    private var contactId = 0
    private var id = 0
    private var contactFirstName = ""
    private var contactLastName = ""
    private var contactAddress = ""
    private var contactPhoneNumber = ""
    private var contactZipCode = ""
    private var contactBirthday = ""

    private lateinit var binding: ActivityEditContactBinding
    private lateinit var viewModel: ContactViewModel
    private lateinit var editContact: Contact
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        val extras = intent.extras
        if (extras != null) {
            showContact(extras)
        } else {
            finish()
        }

        binding.editBirthday.setOnClickListener {
            showDatePickerDialog(binding.editBirthday)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                updateContact()
                return true
            }

            R.id.delete -> {
                deleteDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateContact() {
        val editContactId = id
        val firstName = (binding.editFirstName.text.toString()).capitalize(Locale.ROOT)
        val lastName = (binding.editLastName.text.toString()).capitalize(Locale.ROOT)
        val phoneNumber = binding.editPhoneNumber.text.toString()
        val birthday = binding.editBirthday.text.toString()
        val address = binding.editAddress.text.toString()
        val zipCode = binding.editZipCode.text.toString()
        editContact =
            Contact(editContactId, firstName, lastName, phoneNumber, birthday, address, zipCode)

        if (firstName == "" || lastName == "" || phoneNumber == "" || address == "" || zipCode == "" || birthday == "") {
            Snackbar.make(binding.editDetailLayout, R.string.fill_blank, Snackbar.LENGTH_LONG)
                .show()
        } else {
            viewModel.updateContact(editContact)
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    private fun deleteDialog() {
        val delete = AlertDialog.Builder(this)
            .setTitle(R.string.delete_contact)
            .setMessage(R.string.request_to_delete_message)
            .setPositiveButton(R.string.delete) { _, _ ->
                viewModel.deleteContactById(id)
                finish()
            }
            .setNegativeButton(R.string.decline) { _, _ ->

            }
            .create()
        delete.show()
    }


    private fun showContact(extras: Bundle) {
        contactId = extras.getInt(CONTACT_ID)
        contactFirstName = extras.getString(CONTACT_FIRST_NAME, "")
        contactLastName = extras.getString(CONTACT_LAST_NAME, "")
        contactAddress = extras.getString(CONTACT_ADDRESS, "")
        contactPhoneNumber = extras.getString(CONTACT_PHONE_NUMBER, "")
        contactZipCode = extras.getString(CONTACT_ZIP_CODE, "")
        contactBirthday = extras.getString(CONTACT_BIRTHDAY, "")

        binding.editFirstName.text?.append(contactFirstName)
        binding.editLastName.text?.append(contactLastName)
        binding.editPhoneNumber.text?.append(contactPhoneNumber)
        binding.editAddress.text?.append(contactAddress)
        binding.editZipCode.text?.append(contactZipCode)
        binding.editBirthday.text?.append(contactBirthday)

        val contactId = getContactId(contactId.toInt())
        id = contactId

    }

    private fun getContactId(id: Int): Int {
        return id
    }

}



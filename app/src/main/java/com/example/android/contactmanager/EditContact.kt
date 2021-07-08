package com.example.android.contactmanager

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.android.contactmanager.databinding.ActivityEditContactBinding
import com.example.android.contactmanager.db.Contact
import com.google.android.material.snackbar.Snackbar
import java.util.*


class EditContact : AppCompatActivity() {


    private var contactId = 0L
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

        val extras = intent.extras
        if (extras != null) {
            showContact(extras)
        } else {
            finish()
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
                finish()
                return true
            }

            R.id.delete -> {
                deleteDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateContact(id: Long) {
        val editContactId = viewModel.getContactId(id)
        val firstName = (binding.editFirstName.text.toString()).capitalize(Locale.ROOT)
        val lastName = (binding.editLastName.text.toString()).capitalize(Locale.ROOT)
        val phoneNumber = binding.editPhoneNumber.text.toString()
        val birthday = binding.editBirthday.text.toString()
        val address = binding.editAddress.text.toString()
        val zipCode = binding.editZipCode.text.toString()
        editContact = Contact(editContactId, firstName, lastName, phoneNumber, address, zipCode)

        if (firstName == "" || lastName == "" || phoneNumber == "" || address == "" || zipCode == "" || birthday == "") {
            Snackbar.make(binding.editDetailLayout, R.string.fill_blank, Snackbar.LENGTH_LONG).show()
        } else {
            viewModel.updateContact(editContact)
            Snackbar.make(binding.editDetailLayout,R.string.contact_updated, Snackbar.LENGTH_LONG).show()
        }
    }


    private fun deleteDialog() {
        val delete = AlertDialog.Builder(this)
            .setTitle(getString(R.string.delete_contact))
            .setMessage(getString(R.string.request_to_delete_message))
            .setPositiveButton(getString(R.string.delete)) { _, _ ->
                viewModel.deleteContactById(contactId)
            }
            .setNegativeButton(getString(R.string.decline)) { _, _ ->

            }
            .create()
        delete.show()
    }


    private fun showContact(extras: Bundle) {
        contactId = extras.getLong(CONTACT_ID)
        contactFirstName = extras.getString(CONTACT_FIRST_NAME, "")
        contactLastName = extras.getString(CONTACT_LAST_NAME, "")
        contactAddress = extras.getString(CONTACT_ADDRESS, "")
        contactPhoneNumber = extras.getString(CONTACT_PHONE_NUMBER, "")
        contactZipCode = extras.getString(CONTACT_ZIP_CODE, "")
        contactBirthday = extras.getString(CONTACT_BIRTHDAY, "")

        binding.editFirstName.text?.append(
            contactFirstName.subSequence(
                0,
                contactFirstName.lastIndex
            )
        )
        binding.editLastName.text?.append(contactLastName.subSequence(0, contactLastName.lastIndex))
        binding.editPhoneNumber.text?.append(
            contactPhoneNumber.subSequence(
                0,
                contactFirstName.lastIndex
            )
        )
        binding.editAddress.text?.append(
            contactFirstName.subSequence(
                0,
                contactFirstName.lastIndex
            )
        )
        binding.editZipCode.text?.append(contactZipCode)
        binding.editBirthday.text?.append(contactBirthday)



    }

    private fun getContactId(id: Long) {
         viewModel.getContactId(id)

    }
}



package com.example.android.contactmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.contactmanager.*
import com.example.android.contactmanager.databinding.ActivityMainBinding
import com.example.android.contactmanager.db.*
import com.google.android.material.snackbar.Snackbar

private const val CONTACTS = 100
private const val EDIT_CONTACTS = 200

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
  private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        binding.fabButton.setOnClickListener {
            showContacts()
        }

        initRecyclerview()
    }

    private fun initRecyclerview() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ContactAdapter { selectedItem: Contact -> listItemClicked(selectedItem)}
        binding.recyclerView.adapter  = adapter
        displayContactsList()

    }

    private fun displayContactsList() {
        viewModel.contactLiveData.observe(this, { contact ->
            Log.i("TAG", "displayContactsList: $contact")
            adapter.showContacts(contact)
            adapter.notifyDataSetChanged()
        })

    }

    private fun showContacts(){
        val intent = Intent(this@MainActivity, ContactDetail::class.java)
        startActivityForResult(intent, CONTACTS)
    }

    private fun listItemClicked(contact: Contact) {
        val intent = Intent(this@MainActivity, EditContact::class.java).also {
            it.putExtra(CONTACT_ID,contact.id)
            it.putExtra(CONTACT_FIRST_NAME, contact.firstName)
            it.putExtra(CONTACT_LAST_NAME, contact.lastName)
            it.putExtra(CONTACT_PHONE_NUMBER, contact.phoneNumber)
            it.putExtra(CONTACT_ZIP_CODE, contact.zipCode)
            it.putExtra(CONTACT_ADDRESS,contact.address)
            it.putExtra(CONTACT_BIRTHDAY, contact.birthday)

        }
        startActivityForResult(intent, EDIT_CONTACTS)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            CONTACTS -> {
                Snackbar.make(binding.mainActivityLayout, R.string.contact_added, Snackbar.LENGTH_LONG).show()
            }
            EDIT_CONTACTS -> {
                Snackbar.make(binding.mainActivityLayout, R.string.contact_updated, Snackbar.LENGTH_LONG).show()
            }
            else -> {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

}
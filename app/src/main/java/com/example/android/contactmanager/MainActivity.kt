package com.example.android.contactmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.contactmanager.databinding.ActivityMainBinding
import com.example.android.contactmanager.db.Contact
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabButton.setOnClickListener {
            val intent =  Intent(this@MainActivity, ContactDetail::class.java)
            startActivity(intent)
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
        viewModel.getAllContact()
        viewModel.allContacts.observe(this,{
            adapter.showContacts(it)
            adapter.notifyDataSetChanged()
            Snackbar.make(binding.mainActivityLayout, R.string.contact_added, Snackbar.LENGTH_LONG).show()
        })

    }

    private fun listItemClicked(contact: Contact) {
        val intent = Intent(this@MainActivity, EditContact::class.java).also {
            it.putExtra(CONTACT_ID,contact.id)
            it.putExtra(CONTACT_FIRST_NAME, contact.firstName)
            it.putExtra(CONTACT_LAST_NAME, contact.lastName)
            it.putExtra(CONTACT_PHONE_NUMBER, contact.phoneNumber)
            it.putExtra(CONTACT_ZIP_CODE, contact.zipCode)
            it.putExtra(CONTACT_ADDRESS,contact.address)
            it.putExtra("TEAM", contact.address)
//        it.putExtra(CONTACT_BIRTHDAY,contact.)
            startActivity(it)
        }

    }


}
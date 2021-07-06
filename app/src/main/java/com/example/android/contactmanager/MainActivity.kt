package com.example.android.contactmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.contactmanager.databinding.ActivityMainBinding
import com.example.android.contactmanager.db.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
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
        })
    }

    private fun listItemClicked(contact: Contact) {
        val intent = Intent(this@MainActivity, EditContact::class.java)
        startActivity(intent)
    }


}
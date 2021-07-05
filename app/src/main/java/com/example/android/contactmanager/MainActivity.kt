package com.example.android.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.android.contactmanager.databinding.ActivityMainBinding
import com.example.android.contactmanager.db.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        TODO("Not yet implemented")
    }

    private fun listItemClicked(contact: Contact) {
        TODO("Not yet implemented")
    }


}
package com.example.android.contactmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.contactmanager.databinding.ItemContactBinding
import com.example.android.contactmanager.db.Contact

class ContactAdapter(private val clickListener: (Contact) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {

    private val contactsList = ArrayList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemContactBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(contactsList[position], clickListener)
    }

    override fun getItemCount() = contactsList.size

    fun showContacts(contact: List<Contact>){
        contactsList.clear()
        contactsList.addAll(contact)
    }
}

class MyViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contact: Contact, clickListener: (Contact) -> Unit) {
        binding.firstNames.text = contact.firstName
        binding.lastNames.text = contact.lastName
        binding.listItem.setOnClickListener {
            clickListener(contact)
        }
    }
}
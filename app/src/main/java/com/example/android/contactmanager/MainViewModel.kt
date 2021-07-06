package com.example.android.contactmanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.contactmanager.db.Contact
import com.example.android.contactmanager.db.ContactRepository

class MainViewModel (private val contactRepository: ContactRepository ) : ViewModel() {

    private val _allContacts = MutableLiveData<List<Contact>>()
    val allContacts: LiveData<List<Contact>>
    get() = _allContacts

    fun getAllContact(){
        val contacts = contactRepository.allContacts
        val contactList = mutableListOf<Contact>()
        contactList.addAll(contacts)
    }
}
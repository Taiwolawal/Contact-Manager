package com.example.android.contactmanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.contactmanager.db.Contact
import com.example.android.contactmanager.db.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel (private val contactRepository: ContactRepository ) : ViewModel() {

    private val _allContacts = MutableLiveData<List<Contact>>()
    val allContacts: LiveData<List<Contact>>
    get() = _allContacts

    fun getAllContact(){
        val contacts = contactRepository.allContacts
        val contactList = mutableListOf<Contact>()
        contactList.addAll(contacts)
    }

    fun saveContact(contact: Contact) = viewModelScope.launch {
        contactRepository.insert(contact)
    }
}
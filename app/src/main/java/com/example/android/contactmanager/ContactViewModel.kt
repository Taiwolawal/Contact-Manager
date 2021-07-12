package com.example.android.contactmanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.contactmanager.db.Contact
import com.example.android.contactmanager.db.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(): ViewModel() {



    val contactLiveData =  ContactRepository.allContacts

    fun saveContact(contact: Contact) = viewModelScope.launch {
        ContactRepository.insert(contact)
    }

    fun deleteContactById(id: Int) = viewModelScope.launch {
        ContactRepository.deleteContactById(id)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch {
        ContactRepository.update(contact)
    }

}
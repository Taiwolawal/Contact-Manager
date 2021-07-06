package com.example.android.contactmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.contactmanager.db.Contact
import com.example.android.contactmanager.db.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel (private val contactRepository: ContactRepository): ViewModel() {


    fun saveContact(contact: Contact) = viewModelScope.launch {
       contactRepository.insert(contact)
    }
}
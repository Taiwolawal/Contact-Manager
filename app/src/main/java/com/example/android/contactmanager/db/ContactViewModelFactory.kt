package com.example.android.contactmanager.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.contactmanager.ContactViewModel

class ContactViewModelFactory (private val contactRepository: ContactRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactViewModel::class.java)){
            return ContactViewModel(contactRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}
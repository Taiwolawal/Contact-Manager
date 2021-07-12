package com.example.android.contactmanager.db

import com.example.android.contactmanager.ContactApplication

object ContactRepository {

    private val dao = ContactApplication.database

    val allContacts = dao.contactDao().getAllContact()

    suspend fun  insert (contact: Contact){
        dao.contactDao().insertContact(contact)
    }

    suspend fun update(contact: Contact){
        dao.contactDao().updateContact(contact)
    }

    suspend fun deleteContactById(id: Int){
        dao.contactDao().deleteContactById(id)
    }
}
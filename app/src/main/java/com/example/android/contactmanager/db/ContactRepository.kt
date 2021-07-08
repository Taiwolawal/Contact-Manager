package com.example.android.contactmanager.db

class ContactRepository (private val dao: ContactDao) {

    val allContacts = dao.getAllContact()

    suspend fun  insert (contact: Contact){
        dao.insertContact(contact)
    }

    suspend fun update(contact: Contact){
        dao.updateContact(contact)
    }

    suspend fun deleteContactById(id: Long){
        dao.deleteContactById(id)
    }

    suspend fun  getContactId(id: Long){
        dao.findContactId(id)
    }
}
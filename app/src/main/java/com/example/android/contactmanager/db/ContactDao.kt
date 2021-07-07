package com.example.android.contactmanager.db

import androidx.room.*

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact_data_table ORDER BY contact_first_name ASC ")
     fun getAllContact(): List<Contact>
}
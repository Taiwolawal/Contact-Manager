package com.example.android.contactmanager.db

import androidx.room.*

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateContact(contact: Contact)

    @Query("DELETE  FROM contact_data_table WHERE id = :id")
    suspend fun deleteContactById(id: Long)

    @Query("SELECT * FROM contact_data_table WHERE id = id")
    suspend fun findContactId(id: Long): Contact

    @Query("SELECT * FROM contact_data_table ORDER BY contact_first_name ASC ")
     fun getAllContact(): List<Contact>
}
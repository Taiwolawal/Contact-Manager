package com.example.android.contactmanager.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("DELETE  FROM contact_data_table WHERE id = :id")
    suspend fun deleteContactById(id: Int)


    @Query("SELECT * FROM contact_data_table ORDER BY contact_first_name ASC")
      fun getAllContact(): LiveData<List<Contact>>
}
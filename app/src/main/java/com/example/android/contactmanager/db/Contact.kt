package com.example.android.contactmanager.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact_data_table")
data class Contact(
  @PrimaryKey(autoGenerate = true)
  val id : Int? = null,
  var firstName: String?,
  var lastName: String?,
  var phoneNumber: Int?,
//  var birthday: Date,
  var address: String?,
  var zipCode: Int?
)

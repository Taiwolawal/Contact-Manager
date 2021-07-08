package com.example.android.contactmanager.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact_data_table")
data class Contact(
  @PrimaryKey(autoGenerate = true)
  val id : Int? = null,

  @ColumnInfo(name = "contact_first_name")
  var firstName: String?,

  @ColumnInfo(name = "contact_last_name")
  var lastName: String?,

  @ColumnInfo(name = "contact_phone_number")
  var phoneNumber: String?,
//  var birthday: Date,

  @ColumnInfo(name = "contact_address")
  var address: String?,

  @ColumnInfo(name = "contact_zip_code")
  var zipCode: String?
)

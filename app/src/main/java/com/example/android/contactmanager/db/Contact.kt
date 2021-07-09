package com.example.android.contactmanager.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contact_data_table")
data class Contact(
  @PrimaryKey(autoGenerate = true)
  val id: Long?,

  @ColumnInfo(name = "contact_first_name")
  var firstName: String?,

  @ColumnInfo(name = "contact_last_name")
  var lastName: String?,

  @ColumnInfo(name = "contact_phone_number")
  var phoneNumber: String?,

  @ColumnInfo(name = "contact_birthday_number")
  var birthday: String?,

  @ColumnInfo(name = "contact_address")
  var address: String?,

  @ColumnInfo(name = "contact_zip_code")
  var zipCode: String?
): Serializable
//): Serializable

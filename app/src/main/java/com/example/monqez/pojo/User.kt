package com.example.monqez.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val age: Int,
    val blood_type: String,
    val cancer: String,
    val city: String,
    val diabetes: String,
    val email: String,
    val epidemic_hepatitis: String,
    val first_name: String,
    val gastric_ulcer: String,
    val gastritis: String,
    val gender: String,
    val hepatic_failure: String,
    val icd_code: String,
    val id: Int,
    val last_name: String,
    val lat: String,
    val liver_cirrhosis: String,
    val long: String,
    val national_id: String,
    val phone_1: String,
    val phone_2: String,
    val renal_failure: String,
    val str_address: String,
    val tuberculosis: String
): Parcelable
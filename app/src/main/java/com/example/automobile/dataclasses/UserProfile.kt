package com.example.automobile.dataclasses

import java.util.Date

data class UserProfile(
    val userProfileID: Int? = null,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Date,
    val driverLicenseNumber: Int
)

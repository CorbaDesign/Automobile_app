package com.example.automobile.dataclasses

import java.util.Date

data class Payment(
    val paymentID: Int,
    val amount: Double,
    val currency: String,
    val paymentMethod: String,
    val dateTime: Date,
    val carReservationID: Int
)

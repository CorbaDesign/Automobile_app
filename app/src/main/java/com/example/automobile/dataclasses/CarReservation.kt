package com.example.automobile.dataclasses

import java.util.Date

data class CarReservation(
    val carReservationID: Int,
    val dateTimeFrom: Date,
    val dateTimeUntil: Date,
    val userProfileID: Int,
    val carID: Int
)

package com.example.automobile.dataclasses

import java.util.Date

data class CarAvailabilty(
    val carAvailabilityID: Int,
    val dateTimeFrom: Date,
    val dateTimeUntil: Date,
    val carID: Int
)

package com.example.automobile.dataclasses

data class Car(
    val carID: Int,
    val licensePlate: String,
    val carBrand: String,
    val vehicleType: String,
    val amountOfPassengers: Int,
    val amountOfDoors: Int,
    val automatic: Boolean,
    val gpsAvailable: Boolean,
    val carPriceAmount: Double,
    val carPriceCurrency: Double,
    val userProfileID: Int
)

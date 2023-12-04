package com.example.automobile.dataclasses

data class BonusPointsTransaction(
    val bonusPointsTransactionID: Int,
    val amount: Int,
    val userProfileID: Int,
    val carReservationID: Int,
)

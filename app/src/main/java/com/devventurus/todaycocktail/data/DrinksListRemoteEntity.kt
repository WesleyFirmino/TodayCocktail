package com.devventurus.todaycocktail.data

import com.google.gson.annotations.SerializedName

data class DrinksListRemoteEntity(
    @SerializedName("drinks")
    val DrinkRemoteEntities: List<DrinkRemoteEntity>
)

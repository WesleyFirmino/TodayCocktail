package com.devventurus.todaycocktail.data.network

import com.devventurus.todaycocktail.data.DrinksListRemoteEntity
import retrofit2.http.GET

interface TheCocktailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getDrinks(): DrinksListRemoteEntity
}
package com.devventurus.todaycocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.devventurus.todaycocktail.data.DrinksListRemoteEntity
import com.devventurus.todaycocktail.data.network.CocktailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var drinkName: TextView
    lateinit var drinkContainer: ConstraintLayout
    lateinit var drinkImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        drinkName = findViewById(R.id.drinkName)
        drinkContainer = findViewById(R.id.drinkContainer)
        drinkImage = findViewById(R.id.drinkImage)

        // Primeira imagem que inicia com o app
        getDrink()

        drinkContainer.setOnClickListener{
            getDrink()
        }
    }

    private fun getDrink() {

        lifecycleScope.launch {
            try {
                // Executar Requisição
                val response = requestDrinks()

                // A partir da respota escolher um drink aleatório
                val drink = response.DrinkRemoteEntities.random()

                // Colocar o nome do drink aleatório escolhido no textview
                drinkName.text = drink.strDrink
                Glide.with(this@MainActivity).load(drink.strDrinkThumb).into(drinkImage)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private suspend fun requestDrinks(): DrinksListRemoteEntity {
        // Contexto de execução à suspend funtion
        return withContext(Dispatchers.IO) {
            CocktailService.service.getDrinks()
        }
    }
}
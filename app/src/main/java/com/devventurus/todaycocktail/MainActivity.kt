package com.devventurus.todaycocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var drinkName: TextView
    lateinit var drinkContainer: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        drinkName = findViewById(R.id.drinkName)
        drinkContainer = findViewById(R.id.drinkContainer)

        getDrink()

        drinkContainer.setOnClickListener{
            getDrink()
        }
    }

    private fun getDrink() {
        // Executar Requisição
        // A partir da respota escolher um drink aleatório
        // Colocar o nome do drink aleatório escolhido no textview
    }
}
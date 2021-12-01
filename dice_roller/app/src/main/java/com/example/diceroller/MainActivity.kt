package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Dice(val sidesNumber: Int) {
    fun roll(): Int {
        return (1..sidesNumber).random()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        fun rollDice() {
            val dice = Dice(6)
            val diceRollValue = dice.roll()
            val diceImage: ImageView = findViewById(R.id.imageView)

            val drawableResource = when(diceRollValue) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource);
            diceImage.contentDescription = diceRollValue.toString()
        }

        rollButton.setOnClickListener {
            rollDice()
        }
    }
}
package com.example.diceroller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diceroller.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollBtn.setOnClickListener{
            rollDice()

        }

    }
    fun rollDice(){

        val dice = Dice(6)
        val sides = dice.diceroll()
        val dicer = when(sides){
            1 -> R.drawable.dice_six_faces_one
            2 -> R.drawable.dice_six_faces_two
            3 -> R.drawable.dice_six_faces_four
            4 -> R.drawable.dice_six_faces_four
            5 -> R.drawable.dice_six_faces_five
            else -> R.drawable.dice_six_faces_six
        }

        binding.images.setImageResource(dicer)

    }
}
class Dice(val numSides : Int)
{
    fun diceroll() : Int
    {
        return(1..numSides).random()
    }
}
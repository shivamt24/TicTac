/*
 * If u use my code, u owe me a beer
 */

package com.example.tictac

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "I got destroyed")
        Log.e("MainActivity", "I got destroyed")
    }

    fun buClick(view: View) {
        //bu1.text = "pressed"
        val buSelected: Button = view as Button
        buSelected.text = "Pressed"
        var cellId: Int = 0
        when (buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }

//        Toast.makeText(this, "selected: $cellId", Toast.LENGTH_SHORT).show()
        playGame(cellId, buSelected)

    }

    private var PlayerFirst = ArrayList<Int>()
    private var Player2 = ArrayList<Int>()
    var currentPlayer: Int = 1
    private fun playGame(cellId: Int, buSelected: Button) {
        when (currentPlayer) {
            1 -> {
                buSelected.isEnabled = false
                buSelected.text = "X"
                buSelected.setBackgroundColor(Color.RED)
                currentPlayer = 2
                PlayerFirst.add(cellId)
            }
            2 -> {
                buSelected.isEnabled = false
                buSelected.text = "O"
                buSelected.setBackgroundColor(Color.BLUE)
                currentPlayer = 1
                Player2.add(cellId)
            }
        }
        checkWinner()

    }

    fun checkWinner() {

        var winner: Int = -1

        winner = checkPlzyer(winner)

        if (winner == -1) return

        when (winner) {
            1 -> Toast.makeText(this, "Player 1 Won", Toast.LENGTH_LONG).show()
            2 -> Toast.makeText(this, "player 2 Won", Toast.LENGTH_LONG).show()
        }

        startActivity(Intent(this, MainActivity::class.java))

    }

    private fun checkPlzyer(winner: Int): Int {

        var winner1 = winner
        when {
            PlayerFirst.contains(1) && PlayerFirst.contains(2) && PlayerFirst.contains(3) -> winner1 = 1
            Player2.contains(1) && Player2.contains(2) && Player2.contains(3) -> winner1 = 2
            PlayerFirst.contains(4) && PlayerFirst.contains(5) && PlayerFirst.contains(6) -> winner1 = 1
            Player2.contains(4) && Player2.contains(5) && Player2.contains(6) -> winner1 = 2
            PlayerFirst.contains(7) && PlayerFirst.contains(8) && PlayerFirst.contains(9) -> winner1 = 1
            Player2.contains(7) && Player2.contains(8) && Player2.contains(9) -> winner1 = 2
            PlayerFirst.contains(1) && PlayerFirst.contains(4) && PlayerFirst.contains(7) -> winner1 = 1
            Player2.contains(1) && Player2.contains(4) && Player2.contains(7) -> winner1 = 2
            PlayerFirst.contains(2) && PlayerFirst.contains(5) && PlayerFirst.contains(8) -> winner1 = 1
            Player2.contains(2) && Player2.contains(5) && Player2.contains(8) -> winner1 = 2
            PlayerFirst.contains(3) && PlayerFirst.contains(6) && PlayerFirst.contains(9) -> winner1 = 1
            Player2.contains(3) && Player2.contains(6) && Player2.contains(9) -> winner1 = 2
            PlayerFirst.contains(1) && PlayerFirst.contains(5) && PlayerFirst.contains(9) -> winner1 = 1
            Player2.contains(1) && Player2.contains(5) && Player2.contains(9) -> winner1 = 2
            PlayerFirst.contains(3) && PlayerFirst.contains(5) && PlayerFirst.contains(7) -> winner1 = 1
            Player2.contains(3) && Player2.contains(5) && Player2.contains(7) -> winner1 = 2
        }
        return winner1
    }

}

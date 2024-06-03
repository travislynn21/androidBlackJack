package com.example.blackjackgame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var playerCardsTextView: TextView
    private lateinit var dealerCardsTextView: TextView
    private lateinit var dealButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerCardsTextView = findViewById(R.id.player_cards)
        dealerCardsTextView = findViewById(R.id.dealer_cards)
        dealButton = findViewById(R.id.deal_button)

        dealButton.setOnClickListener {
            dealCards()
        }
    }

    private fun dealCards() {
        val playerCards = generateRandomBlackjackHand()
        val dealerCards = generateRandomBlackjackHand()

        playerCardsTextView.text = "Player Cards: ${playerCards.joinToString(", ")}"
        dealerCardsTextView.text = "Dealer Cards: ${dealerCards.joinToString(", ")}"
    }

    private fun generateRandomBlackjackHand(): List<String> {
        val randomValue = Random.nextInt(1, 5)
        return when (randomValue) {
            1 -> listOf("A", "10")
            2 -> listOf("10", "A")
            3 -> listOf("J", "A")
            4 -> listOf("A", "J")
            else -> listOf("A", "K")
        }
    }
}

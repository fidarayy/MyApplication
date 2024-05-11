package org.d3if3138.myapplication

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.lang.Exception

class ViewModel: ViewModel() {
    private val _state = MutableStateFlow(StateClass())
    val  state = _state.asStateFlow()

    fun updateTextField(userNo: String) {
        _state.update { it.copy(userNumber = userNo) }
    }

    fun resetGame() {
        _state.value = StateClass()
    }


    fun onUserInput(
        userNumber: String,
        context: Context
    ) {
        val userNumberInInt = try {
            userNumber.toInt()
        } catch (e: Exception) {
            0
        }

        if (userNumberInInt !in 1..100) {
            Toast.makeText(
                context,
                "Mohon masukan angkat antar 0 dan 50. ",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val currentState = _state.value

        val newGuessLeft = currentState.noOfMysteryLeft - 1
        val newGameStage = when {
            userNumberInInt == currentState.mysteryNumber -> GameStage.MENANG
            newGuessLeft == 0 -> GameStage.KALAH
            else -> GameStage.BERMAIN
        }
        val newHintDescription = when {
            userNumberInInt > currentState.mysteryNumber -> {
                "Petunjuk\nKamu menebak angka yang lebih besar dari angka misteri."
            }

            userNumberInInt < currentState.mysteryNumber -> {
                "Petunjuk\nKamu menebak angka yang lebih kecil dari angka misteri."
            }

            else -> ""
        }
        val newGuessNoList = currentState.mysteryNumberList.plus(userNumberInInt)

        _state.update {
            it.copy(
                userNumber = "",
                noOfMysteryLeft = newGuessLeft,
                mysteryNumberList = newGuessNoList,
                hintDescription = newHintDescription,
                gameStage = newGameStage
            )
        }
    }
}
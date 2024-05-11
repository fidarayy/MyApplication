package org.d3if3138.myapplication

import android.accounts.AuthenticatorDescription

data class StateClass(
    val userNumber: String = "",
    val noOfMysteryLeft: Int = 5,
    val mysteryNumberList: List<Int> = emptyList(),
    val mysteryNumber: Int = (1..50).random(),
    val hintDescription: String = "Petunjuk\n angka misteri ada di antara\n0 dan 100.",
    val gameStage: GameStage = GameStage.BERMAIN

)
enum class GameStage {
    MENANG,
    KALAH,
    BERMAIN
}


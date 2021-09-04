package com.meeweel.tictactoe.model

class TicMap {
    val ai: AI = AI()
    var map = mutableListOf(
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0)
    )

    fun humanStep(x: Int, y: Int) {
        map[x][y] = 1
    }
    fun AIStep() {
        ai.AIStep(map)
        map[ai.x!!][ai.y!!]
    }
}
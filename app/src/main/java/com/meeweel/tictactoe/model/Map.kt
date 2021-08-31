package com.meeweel.tictactoe.model

class Map {
    val ai: AI = AI()
    var map = mutableListOf(
        mutableListOf(0,0,0,0,0),
        mutableListOf(0,0,0,0,0),
        mutableListOf(0,0,0,0,0),
        mutableListOf(0,0,0,0,0),
        mutableListOf(0,0,0,0,0)
    )

    private fun humanStep(x: Int, y: Int) {
        map[x][y] = 1
        ai.AIStep(map)
        map[ai.x!!][ai.y!!]
    }

}
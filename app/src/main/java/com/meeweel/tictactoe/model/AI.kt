package com.meeweel.tictactoe.model

class AI {
    var done = 0
    var x: Int? = null
    var y: Int? = null
    fun aiStep(map: MutableList<MutableList<Int>>) {
        done = 0
        while (done == 0) {
            x = (0 until 5).random()
            y = (0 until 5).random()
            if (map[x!!][y!!] == 0) {
                map[x!!][y!!] = 2
                done = 1
            }
        }
    }
}
package com.meeweel.tictactoe.model

class AI {
    val DOT_O = 2
    var done = 0
    private val SIZE = 5
    private val DOTS_TO_WIN = 4
    var isFind = false
    var x: Int? = null
    var y: Int? = null
    fun aiStep(map: MutableList<MutableList<Int>>) {
        isFind = false
        done = 0

        if (!isFind){
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
    private fun vertical(localMap: MutableList<MutableList<Int>>, dot: Int) : Boolean {
        var row: Int = 0 // счётчик для определения победной серии

        for (i in 0 until SIZE) {
            for (j in 0..SIZE - DOTS_TO_WIN) {
                row = 0 // обнуляю счётчик перед прогоном
                for (g in 0 until DOTS_TO_WIN) {
                    if (localMap[i][j + g] == dot) row++
                }
                if (row == DOTS_TO_WIN) return true
            }
        }
        return false
    }
    private fun horizontal(localMap: MutableList<MutableList<Int>>, dot: Int) : Boolean {
        var row: Int = 0 // счётчик для определения победной серии

        for (i in 0 until SIZE) {
            for (j in 0..SIZE - DOTS_TO_WIN) {
                row = 0 // обнуляю счётчик перед прогоном
                for (g in 0 until DOTS_TO_WIN) {
                    if (localMap[j + g][i] == dot) row++
                }
                if (row == DOTS_TO_WIN) return true
            }
        }
        return false
    }
    private fun diagonalDown(localMap: MutableList<MutableList<Int>>, dot: Int) : Boolean {
        var row: Int = 0 // счётчик для определения победной серии

        for (i in 0..SIZE - DOTS_TO_WIN) {
            for (j in 0..SIZE - DOTS_TO_WIN) {
                row = 0 // обнуляю счётчик перед прогоном
                for (g in 0 until DOTS_TO_WIN) {
                    if (localMap[g + j][g + i] == dot) row++
                }
                if (row == DOTS_TO_WIN) return true
            }
        }
        return false
    }
    private fun diagonalUp(localMap: MutableList<MutableList<Int>>, dot: Int) : Boolean {
        var row: Int = 0 // счётчик для определения победной серии

        for (i in DOTS_TO_WIN - 1 until SIZE) {
            for (j in 0..SIZE - DOTS_TO_WIN) {
                row = 0 // обнуляю счётчик перед прогоном
                for (g in 0 until DOTS_TO_WIN) {
                    if (localMap[i - g][j + g] == dot) row++
                }
                if (row == DOTS_TO_WIN) return true
            }
        }
        return false
    }
}
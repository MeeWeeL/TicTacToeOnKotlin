package com.meeweel.tictactoe.model

class TicMap {
    var winner = 0
    private val SIZE = 5
    private val DOTS_TO_WIN = 4
    private val ai: AI = AI()
    var map: MutableList<MutableList<Int>> = mutableListOf(
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0)
    )

    fun humanStep(x: Int, y: Int) {
        map[x][y] = 1
        if (checkWin(map, 1)) winner = 1
    }
    fun aiStep() {
        ai.aiStep(map)
        if (checkWin(map, 2)) winner = 2
        map[ai.x!!][ai.y!!]
    }
    private fun checkWin(localMap: MutableList<MutableList<Int>>, dot: Int) : Boolean {
        if (vertical(localMap, dot)) return true;
        if (horizontal(localMap, dot)) return true;
        if (diagonalDown(localMap, dot)) return true;
        if (diagonalUp(localMap, dot)) return true;
        return false;
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
package com.meeweel.tictactoe.model

class AI {
    val enemy = 1
    val dot = 2
    val defaultDot = 0
    var done = 0
    private val SIZE = 5
    private val DOTS_TO_WIN = 4
    var x: Int? = null
    var y: Int? = null
    fun aiStep(map: MutableList<MutableList<Int>>) {
        done = 0
        do {
            if (verticalAiTurn(map, DOTS_TO_WIN, dot)) break
            if (horizontalAiTurn(map, DOTS_TO_WIN, dot)) break
            if (diagonalDownAiTurn(map, DOTS_TO_WIN, dot)) break
            if (diagonalUpAiTurn(map, DOTS_TO_WIN, dot)) break
            if (verticalAiTurn(map, DOTS_TO_WIN, enemy)) break
            if (horizontalAiTurn(map, DOTS_TO_WIN, enemy)) break
            if (diagonalDownAiTurn(map, DOTS_TO_WIN, enemy)) break
            if (diagonalUpAiTurn(map, DOTS_TO_WIN, enemy)) break
            if (verticalAiTurn(map, DOTS_TO_WIN - 1, enemy)) break
            if (horizontalAiTurn(map, DOTS_TO_WIN - 1, enemy)) break
            if (diagonalDownAiTurn(map, DOTS_TO_WIN - 1, enemy)) break
            if (diagonalUpAiTurn(map, DOTS_TO_WIN - 1, enemy)) break
            if (verticalAiTurn(map, DOTS_TO_WIN - 1, dot)) break
            if (horizontalAiTurn(map, DOTS_TO_WIN - 1, dot)) break
            if (diagonalDownAiTurn(map, DOTS_TO_WIN - 1, dot)) break
            if (diagonalUpAiTurn(map, DOTS_TO_WIN - 1, dot)) break
            if (verticalAiTurn(map, DOTS_TO_WIN - 2, enemy)) break
            if (horizontalAiTurn(map, DOTS_TO_WIN - 2, enemy)) break
            if (diagonalDownAiTurn(map, DOTS_TO_WIN - 2, enemy)) break
            if (diagonalUpAiTurn(map, DOTS_TO_WIN - 2, enemy)) break
            while (done == 0) {
                x = (0 until 5).random()
                y = (0 until 5).random()
                if (map[x!!][y!!] == 0) {
                    done = 1
                }
            }
        } while (false)
        map[x!!][y!!] = dot
    }


    private fun horizontalAiTurn(map: MutableList<MutableList<Int>>, winRate: Int, findingDot: Int) : Boolean {
        var row: Int // счётчик для определения победной серии
        var g: Int // for for
        for (i in 0 until SIZE) {
            for (j in 0..SIZE - winRate) {
                row = 0 // обнуляю счётчик перед прогоном
                g = 0
                while (g < winRate) {
                    if (j + g in 0 until SIZE) {
                        if (map[i][j + g] == findingDot) row++
                    }
                    g++
                }
                if (row == winRate - 1) {
                    g = 0
                    while (g < winRate) {
                        if (j + g in 0 until SIZE) {
                            if (map[i][j + g] == defaultDot) {
                                x = i
                                y = j + g
                                return true
                            }
                        }
                        g++
                    }
                }
            }
        }
        return false
    }
    private fun verticalAiTurn(map: MutableList<MutableList<Int>>, winRate: Int, findingDot: Int) : Boolean {
        var row: Int // счётчик для определения победной серии
        var g: Int // for for
        for (j in 0 until SIZE) {
            for (i in 0..SIZE - winRate) {
                row = 0 // обнуляю счётчик перед прогоном
                g = 0
                while (g < winRate) {
                    if (i + g in 0 until SIZE) {
                        if (map[i + g][j] == findingDot) row++
                    }
                    g++
                }
                if (row == winRate - 1) {
                    g = 0
                    while (g < winRate) {
                        if (i + g in 0 until SIZE) {
                            if (map[i + g][j] == defaultDot) {
                                x = i + g
                                y = j
                                return true
                            }
                        }
                        g++
                    }
                }
            }
        }
        return false
    }
    private fun diagonalDownAiTurn(map: MutableList<MutableList<Int>>, winRate: Int, findingDot: Int) : Boolean {
        var row: Int // счётчик для определения победной серии
        var g: Int // for for
        for (i in 0..SIZE - DOTS_TO_WIN) {
            for (j in 0..SIZE - DOTS_TO_WIN) {
                row = 0 // обнуляю счётчик перед прогоном
                g = 0
                while (g < winRate) {
                    if (i + g in 0 until SIZE && j + g in 0 until SIZE) {
                        if (map[i + g][j + g] == findingDot) row++
                    }
                    g++
                }
                if (row == winRate - 1) {
                    g = 0
                    while (g < winRate) {
                        if (i + g in 0 until SIZE && j + g in 0 until SIZE) {
                            if (map[i + g][j + g] == defaultDot) {
                                x = i + g
                                y = j + g
                                return true
                            }
                        }
                        g++
                    }
                }
            }
        }
        return false
    }
    private fun diagonalUpAiTurn(map: MutableList<MutableList<Int>>, winRate: Int, findingDot: Int) : Boolean {
        var row: Int // счётчик для определения победной серии
        var g: Int // for for
        for (i in 0..SIZE - DOTS_TO_WIN) {
            for (j in DOTS_TO_WIN - 1 until SIZE) {
                row = 0 // обнуляю счётчик перед прогоном
                g = 0
                while (g < winRate) {
                    if (i + g in 0 until SIZE && j - g in 0 until SIZE) {
                        if (map[i + g][j - g] == findingDot) row++
                    }
                    g++
                }
                if (row == winRate - 1) {
                    g = 0
                    while (g < winRate) {
                        if (i + g in 0 until SIZE && j - g in 0 until SIZE) {
                            if (map[i + g][j - g] == defaultDot) {
                                x = i + g
                                y = j - g
                                return true
                            }
                        }
                        g++
                    }
                }
            }
        }
        return false
    }

}
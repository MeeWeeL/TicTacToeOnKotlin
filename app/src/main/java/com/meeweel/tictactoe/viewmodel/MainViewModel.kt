package com.meeweel.tictactoe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meeweel.tictactoe.model.TicMap


class MainViewModel() : ViewModel() {
    private val mainMap: TicMap = TicMap()
    val liveDataWinner: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData00: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData01: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData02: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData03: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData04: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData10: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData11: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData12: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData13: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData14: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData20: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData21: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData22: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData23: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData24: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData30: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData31: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData32: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData33: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData34: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData40: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData41: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData42: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData43: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveData44: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun set() {
        liveData00.value = mainMap.map[0][0]
        liveData01.value = mainMap.map[0][1]
        liveData02.value = mainMap.map[0][2]
        liveData03.value = mainMap.map[0][3]
        liveData04.value = mainMap.map[0][4]
        liveData10.value = mainMap.map[1][0]
        liveData11.value = mainMap.map[1][1]
        liveData12.value = mainMap.map[1][2]
        liveData13.value = mainMap.map[1][3]
        liveData14.value = mainMap.map[1][4]
        liveData20.value = mainMap.map[2][0]
        liveData21.value = mainMap.map[2][1]
        liveData22.value = mainMap.map[2][2]
        liveData23.value = mainMap.map[2][3]
        liveData24.value = mainMap.map[2][4]
        liveData30.value = mainMap.map[3][0]
        liveData31.value = mainMap.map[3][1]
        liveData32.value = mainMap.map[3][2]
        liveData33.value = mainMap.map[3][3]
        liveData34.value = mainMap.map[3][4]
        liveData40.value = mainMap.map[4][0]
        liveData41.value = mainMap.map[4][1]
        liveData42.value = mainMap.map[4][2]
        liveData43.value = mainMap.map[4][3]
        liveData44.value = mainMap.map[4][4]
        liveDataWinner.value = mainMap.winner
    }

    fun step(x: Int, y: Int) {
        mainMap.humanStep(x,y)
        if (mainMap.winner == 0) {
            mainMap.aiStep()
        }
        set()
    }
    fun refresh() {
        for (i in 0..4) {
            for (j in 0..4) {
                mainMap.map[i][j] = 0
            }
        }
        mainMap.winner = 0
        set()
    }
    fun checkPosition(x: Int, y: Int): Boolean {
        return mainMap.map[x][y] == 0
    }
}
package com.meeweel.tictactoe.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.meeweel.tictactoe.R
import com.meeweel.tictactoe.databinding.MainActivityBinding
import com.meeweel.tictactoe.model.TicMap
import com.meeweel.tictactoe.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: MainActivityBinding
    var listener: View.OnClickListener? = null
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
        setClickers(listener)
        viewModel.set()
        showToast("Gaga")
    }

    override fun onClick(v: View?) {
    }

    override fun onResume() {
        super.onResume()
        viewModel.set()
        viewModel.liveDataWinner.observe(this, {
            if (it != 0) setClickers(null)
            if (it == 1) Toast.makeText(this, "You Win!!!", Toast.LENGTH_LONG).show()
            if (it == 2) Toast.makeText(this, "You Lose!!!", Toast.LENGTH_LONG).show()
        })
        viewModel.liveData00.observe(this, {
            changeImage(it, binding.position00)
        })
        viewModel.liveData01.observe(this, {
            changeImage(it, binding.position01)
        })
        viewModel.liveData02.observe(this, {
            changeImage(it, binding.position02)
        })
        viewModel.liveData03.observe(this, {
            changeImage(it, binding.position03)
        })
        viewModel.liveData04.observe(this, {
            changeImage(it, binding.position04)
        })
        viewModel.liveData10.observe(this, {
            changeImage(it, binding.position10)
        })
        viewModel.liveData11.observe(this, {
            changeImage(it, binding.position11)
        })
        viewModel.liveData12.observe(this, {
            changeImage(it, binding.position12)
        })
        viewModel.liveData13.observe(this, {
            changeImage(it, binding.position13)
        })
        viewModel.liveData14.observe(this, {
            changeImage(it, binding.position14)
        })
        viewModel.liveData20.observe(this, {
            changeImage(it, binding.position20)
        })
        viewModel.liveData21.observe(this, {
            changeImage(it, binding.position21)
        })
        viewModel.liveData22.observe(this, {
            changeImage(it, binding.position22)
        })
        viewModel.liveData23.observe(this, {
            changeImage(it, binding.position23)
        })
        viewModel.liveData24.observe(this, {
            changeImage(it, binding.position24)
        })
        viewModel.liveData30.observe(this, {
            changeImage(it, binding.position30)
        })
        viewModel.liveData31.observe(this, {
            changeImage(it, binding.position31)
        })
        viewModel.liveData32.observe(this, {
            changeImage(it, binding.position32)
        })
        viewModel.liveData33.observe(this, {
            changeImage(it, binding.position33)
        })
        viewModel.liveData34.observe(this, {
            changeImage(it, binding.position34)
        })
        viewModel.liveData40.observe(this, {
            changeImage(it, binding.position40)
        })
        viewModel.liveData41.observe(this, {
            changeImage(it, binding.position41)
        })
        viewModel.liveData42.observe(this, {
            changeImage(it, binding.position42)
        })
        viewModel.liveData43.observe(this, {
            changeImage(it, binding.position43)
        })
        viewModel.liveData44.observe(this, {
            changeImage(it, binding.position44)
        })
    }
    fun showToast(message: String){
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
    }
    private fun changeImage(a: Int, b: ImageButton) {
        when (a) {
            0 -> b.setImageResource(R.drawable.value_0)
            1 -> b.setImageResource(R.drawable.value_1)
            2 -> b.setImageResource(R.drawable.value_2)
        }
    }
    fun setListener() {
        listener = View.OnClickListener { v ->
            with (binding) {
                when (v) {
                    position00 -> if (viewModel.liveData00.value == 0) {
                        viewModel.liveData00.value = 1
                        viewModel.step(0, 0)
                    }
                    position01 -> if (viewModel.liveData01.value == 0) {
                        viewModel.liveData01.value = 1
                        viewModel.step(0, 1)
                    }
                    position02 -> if (viewModel.liveData02.value == 0) {
                        viewModel.liveData02.value = 1
                        viewModel.step(0, 2)
                    }
                    position03 -> if (viewModel.liveData03.value == 0) {
                        viewModel.liveData03.value = 1
                        viewModel.step(0, 3)
                    }
                    position04 -> if (viewModel.liveData04.value == 0) {
                        viewModel.liveData04.value = 1
                        viewModel.step(0, 4)
                    }
                    position10 -> if (viewModel.liveData10.value == 0) {
                        viewModel.liveData10.value = 1
                        viewModel.step(1, 0)
                    }
                    position11 -> if (viewModel.liveData11.value == 0) {
                        viewModel.liveData11.value = 1
                        viewModel.step(1, 1)
                    }
                    position12 -> if (viewModel.liveData12.value == 0) {
                        viewModel.liveData12.value = 1
                        viewModel.step(1, 2)
                    }
                    position13 -> if (viewModel.liveData13.value == 0) {
                        viewModel.liveData13.value = 1
                        viewModel.step(1, 3)
                    }
                    position14 -> if (viewModel.liveData14.value == 0) {
                        viewModel.liveData14.value = 1
                        viewModel.step(1, 4)
                    }
                    position20 -> if (viewModel.liveData20.value == 0) {
                        viewModel.liveData20.value = 1
                        viewModel.step(2, 0)
                    }
                    position21 -> if (viewModel.liveData21.value == 0) {
                        viewModel.liveData21.value = 1
                        viewModel.step(2, 1)
                    }
                    position22 -> if (viewModel.liveData22.value == 0) {
                        viewModel.liveData22.value = 1
                        viewModel.step(2, 2)
                    }
                    position23 -> if (viewModel.liveData23.value == 0) {
                        viewModel.liveData23.value = 1
                        viewModel.step(2, 3)
                    }
                    position24 -> if (viewModel.liveData24.value == 0) {
                        viewModel.liveData24.value = 1
                        viewModel.step(2, 4)
                    }
                    position30 -> if (viewModel.liveData30.value == 0) {
                        viewModel.liveData30.value = 1
                        viewModel.step(3, 0)
                    }
                    position31 -> if (viewModel.liveData31.value == 0) {
                        viewModel.liveData31.value = 1
                        viewModel.step(3, 1)
                    }
                    position32 -> if (viewModel.liveData32.value == 0) {
                        viewModel.liveData32.value = 1
                        viewModel.step(3, 2)
                    }
                    position33 -> if (viewModel.liveData33.value == 0) {
                        viewModel.liveData33.value = 1
                        viewModel.step(3, 3)
                    }
                    position34 -> if (viewModel.liveData34.value == 0) {
                        viewModel.liveData34.value = 1
                        viewModel.step(3, 4)
                    }
                    position40 -> if (viewModel.liveData40.value == 0) {
                        viewModel.liveData40.value = 1
                        viewModel.step(4, 0)
                    }
                    position41 -> if (viewModel.liveData41.value == 0) {
                        viewModel.liveData41.value = 1
                        viewModel.step(4, 1)
                    }
                    position42 -> if (viewModel.liveData42.value == 0) {
                        viewModel.liveData42.value = 1
                        viewModel.step(4, 2)
                    }
                    position43 -> viewModel.refresh()
                    position44 -> viewModel.set()
                }
            }
        }
    }
    fun setClickers(v: View.OnClickListener?) {

        binding.position00.setOnClickListener(v)
        binding.position01.setOnClickListener(v)
        binding.position02.setOnClickListener(v)
        binding.position03.setOnClickListener(v)
        binding.position04.setOnClickListener(v)
        binding.position10.setOnClickListener(v)
        binding.position11.setOnClickListener(v)
        binding.position12.setOnClickListener(v)
        binding.position13.setOnClickListener(v)
        binding.position14.setOnClickListener(v)
        binding.position20.setOnClickListener(v)
        binding.position21.setOnClickListener(v)
        binding.position22.setOnClickListener(v)
        binding.position23.setOnClickListener(v)
        binding.position24.setOnClickListener(v)
        binding.position30.setOnClickListener(v)
        binding.position31.setOnClickListener(v)
        binding.position32.setOnClickListener(v)
        binding.position33.setOnClickListener(v)
        binding.position34.setOnClickListener(v)
        binding.position40.setOnClickListener(v)
        binding.position41.setOnClickListener(v)
        binding.position42.setOnClickListener(v)
        binding.position43.setOnClickListener(v)
        binding.position44.setOnClickListener(v)
    }
}
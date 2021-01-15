package com.example.mylesson13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.view.marginBottom
import com.example.mylesson13.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var n = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnIncrement.setOnClickListener {
            binding.tvNumber.text = n.toString()
            binding.tvNumber.visibility = View.INVISIBLE
            binding.pbCircle.visibility = View.VISIBLE
            binding.btnIncrement.visibility = View.GONE

            waitingThread()
        }
    }

    private fun visibilityViews() {
        binding.pbCircle.visibility = View.INVISIBLE
        binding.tvNumber.text = "N = ${(n).toString()}"
        binding.tvNumber.visibility = View.VISIBLE
        binding.btnIncrement.visibility = View.VISIBLE
    }

    private fun waitingThread() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                visibilityViews()
            }, ((n + 1) * 1000L / 10)
        )
        n += 1
    }
}
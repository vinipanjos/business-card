package com.vinicius.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinicius.businesscard.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListenersButtons()
    }

    private fun setupListenersButtons() {
        binding.closeBtn.setOnClickListener {
            finish()
        }
        binding.confirmBtn.setOnClickListener {

        }
    }
}
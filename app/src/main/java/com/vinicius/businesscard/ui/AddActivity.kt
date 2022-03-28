package com.vinicius.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.vinicius.businesscard.App
import com.vinicius.businesscard.R
import com.vinicius.businesscard.data.BusinessCard
import com.vinicius.businesscard.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private  val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

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
            val businessCard = BusinessCard(
                name = binding.nameTil.editText?.text.toString(),
                company = binding.companyTil.editText?.text.toString(),
                phoneNumber = binding.numberPhoneTil.editText?.text.toString(),
                email = binding.emailTil.editText?.text.toString(),
                backgroundUser = binding.colorTil.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.show_sucess_message, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
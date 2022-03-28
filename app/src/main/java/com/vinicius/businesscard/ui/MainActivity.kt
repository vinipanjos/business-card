package com.vinicius.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.vinicius.businesscard.App
import com.vinicius.businesscard.databinding.ActivityMainBinding
import com.vinicius.businesscard.util.Image

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy {BusinessCardAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cardsRv.adapter = adapter
        getAllBusinessCard()
        setupFloatingActionButton()
    }

    private fun setupFloatingActionButton() {
        binding.addBtn.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = {card ->
            Image.share(this@MainActivity, card)
        }

    }

    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this, {
            adapter.submitList(it)
        })
    }
}
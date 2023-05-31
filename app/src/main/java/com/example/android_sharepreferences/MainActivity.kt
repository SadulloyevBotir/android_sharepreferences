package com.example.android_sharepreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_sharepreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {

        binding.bnSave.setOnClickListener {
            val smth = binding.etSmth.text.toString().trim()
            saveSmth(smth)
            binding.etSmth.text.clear()
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
        }

        binding.bnLoad.setOnClickListener {
            binding.textview.text = "You are saved this " + "-> ${loadSmth()}"
        }
    }

    fun saveSmth(smth: String) {
        val prefs = applicationContext.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("smth", binding.etSmth.text.toString().trim())
        editor.apply()
    }

    fun loadSmth(): String? {
        val prefs = applicationContext.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        return prefs.getString("smth", "NOT FOUND")
    }
}

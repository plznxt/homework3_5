package com.geektechhw.homework3_5

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektechhw.homework3_5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra("key")
        binding.edVal2.setText(text)

        initListeners()
    }

    private fun initListeners() {
        binding.send.setOnClickListener{
            val intent = Intent()
            intent.putExtra("result", binding.edVal2.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}
package com.geektechhw.homework3_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.geektechhw.homework3_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var launchForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val text = result.data?.getStringExtra("result")
            binding.edVal.setText(text)
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.send.setOnClickListener{
            if (binding.edVal.text.isNotEmpty()){
                var intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("key", binding.edVal.text.toString())
                launchForResult.launch(intent)
            } else {
            Toast.makeText(this, "Edit text can not be empty",
                Toast.LENGTH_SHORT).show()
            }
        }
    }

}
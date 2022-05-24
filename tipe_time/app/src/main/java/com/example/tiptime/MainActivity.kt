package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTips() }
    }

    private fun displayTips(tips: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tips)
        binding.tipsResult.text = getString(R.string.tips_amount, formattedTip)
    }

     private fun calculateTips(){
        val cost = binding.costOfService.text.toString().toDoubleOrNull()

         if (cost != null || cost == 0.0) {
             val tipsPercent = when (binding.tipsOptions.checkedRadioButtonId) {
                 R.id.options_amazing -> 0.2
                 R.id.options_good -> 0.18
                 else -> 0.15
             }
             var tips = cost * tipsPercent

             if (binding.roundUpSwitch.isChecked) {
                 tips = kotlin.math.ceil(tips)
             }

             displayTips(tips)
         } else {
             displayTips(0.0)
         }
    }
}
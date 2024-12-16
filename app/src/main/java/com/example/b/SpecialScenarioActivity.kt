package com.example.b

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SpecialScenarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special_scenario)

        val optionOneButton: Button = findViewById(R.id.optionOneButton)
        val optionTwoButton: Button = findViewById(R.id.optionTwoButton)
        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val hintTextView: TextView = findViewById(R.id.hintTextView)

        // 顯示題目
        questionTextView.text = "在路上發生車禍應該如何處理？"

        // 點擊選項一：報警
        optionOneButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：報警", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ReportQuestionActivity::class.java)
            startActivity(intent)
        }

        // 點擊選項二：直接開走
        optionTwoButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：直接開走", Toast.LENGTH_SHORT).show()
            hintTextView.text = "沒事的，再試試看！"
            hintTextView.visibility = TextView.VISIBLE
            android.os.Handler(Looper.getMainLooper()).postDelayed({
                hintTextView.visibility = TextView.GONE
            }, 2000)
        }
    }
}

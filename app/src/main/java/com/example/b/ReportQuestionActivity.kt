package com.example.b

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReportQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_question)

        val optionOneButton: Button = findViewById(R.id.optionOneButton)
        val optionTwoButton: Button = findViewById(R.id.optionTwoButton)
        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val hintTextView: TextView = findViewById(R.id.hintTextView)
        // 顯示報警時該說什麼的題目
        questionTextView.text = "報警時該說什麼？"

        // 點擊選項一：我在(發生車禍的地方)發生車禍了
        optionOneButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：我在(發生車禍的地方)發生車禍了", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PoliceReportActivity::class.java)
            startActivity(intent)
        }

        // 點擊選項二：我在這裡出車禍了
        optionTwoButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：我在這裡出車禍了", Toast.LENGTH_SHORT).show()
            hintTextView.text = "沒事的，再試試看！"
            hintTextView.visibility = TextView.VISIBLE
            android.os.Handler(Looper.getMainLooper()).postDelayed({
                hintTextView.visibility = TextView.GONE
            }, 2000)
        }
    }
}

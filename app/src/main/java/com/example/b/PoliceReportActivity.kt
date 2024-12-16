package com.example.b

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PoliceReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_police_report)

        val optionOneButton: Button = findViewById(R.id.optionOneButton)
        val optionTwoButton: Button = findViewById(R.id.optionTwoButton)
        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val hintTextView: TextView = findViewById(R.id.hintTextView)
        val congratulationsTextView: TextView = findViewById(R.id.congratulationsTextView)
        val homeButton: Button = findViewById(R.id.homeButton)

        questionTextView.text = "警察到現場要說什麼？"

        // 點擊選項一：我在右轉時跟直行的車擦撞了
        optionOneButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：我在右轉時跟直行的車擦撞了", Toast.LENGTH_SHORT).show()
            hintTextView.visibility = TextView.GONE
            optionOneButton.isEnabled = false
            optionTwoButton.isEnabled = false
            congratulationsTextView.text = "恭喜你完成這次對話挑戰！"
            congratulationsTextView.visibility = TextView.VISIBLE
            homeButton.visibility = Button.VISIBLE
        }
        // 點擊選項二：我剛剛撞到他了
        optionTwoButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：我剛剛撞到他了", Toast.LENGTH_SHORT).show()
            hintTextView.text = "沒事的，再試試看！"
            hintTextView.visibility = TextView.VISIBLE
            android.os.Handler(Looper.getMainLooper()).postDelayed({
                hintTextView.visibility = TextView.GONE
            }, 2000)
        }
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

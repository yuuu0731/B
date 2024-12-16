package com.example.b

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Handler

class ResponseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_response)

        val optionOneButton: Button = findViewById(R.id.optionOneButton)
        val optionTwoButton: Button = findViewById(R.id.optionTwoButton)
        val hintTextView: TextView = findViewById(R.id.hintTextView)
        val congratulationsTextView: TextView = findViewById(R.id.congratulationsTextView)
        val homeButton: Button = findViewById(R.id.homeButton)

        // 點擊選項一：不說話
        optionOneButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：不說話", Toast.LENGTH_SHORT).show()
            hintTextView.text = "沒事的，再試試看！"
            hintTextView.visibility = TextView.VISIBLE
            android.os.Handler(Looper.getMainLooper()).postDelayed({
                hintTextView.visibility = TextView.GONE
            }, 2000)  // 延時 2 秒（2000 毫秒）
        }

        // 點擊選項二：謝謝
        optionTwoButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：謝謝", Toast.LENGTH_SHORT).show()
            hintTextView.visibility = TextView.GONE
            optionOneButton.isEnabled = false
            optionTwoButton.isEnabled = false
            congratulationsTextView.text = "恭喜你完成這次對話挑戰！"
            congratulationsTextView.visibility = TextView.VISIBLE
            homeButton.visibility = Button.VISIBLE
        }
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

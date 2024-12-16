package com.example.b

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DialogueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogue)

        val optionOneButton: Button = findViewById(R.id.optionOneButton)
        val optionTwoButton: Button = findViewById(R.id.optionTwoButton)
        val hintTextView: TextView = findViewById(R.id.hintTextView)


        // 點擊選項一
        optionOneButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：不好意思請問冰塊在哪？", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ResponseActivity::class.java)
            startActivity(intent)
        }

        // 點擊選項二
        optionTwoButton.setOnClickListener {
            Toast.makeText(this, "你選擇了：冰塊呢？", Toast.LENGTH_SHORT).show()
            hintTextView.text = "沒事的，再試試看！"
            hintTextView.visibility = TextView.VISIBLE
            android.os.Handler(Looper.getMainLooper()).postDelayed({
                hintTextView.visibility = TextView.GONE
            }, 2000)  // 延時 2 秒（2000 毫秒）
        }
    }
}

package com.example.b

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.b.R

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val dailyScenarioButton: Button = findViewById(R.id.dailyScenarioButton)
        val specialScenarioButton: Button = findViewById(R.id.specialScenarioButton)

        // 點擊日常情境按鈕
        dailyScenarioButton.setOnClickListener {
            Toast.makeText(this, "進入日常情境", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            // 這裡可以添加跳轉到日常情境的 Activity
        }

        // 點擊特殊情境按鈕
        specialScenarioButton.setOnClickListener {
            Toast.makeText(this, "進入特殊情境", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SpecialScenarioActivity::class.java)
            startActivity(intent)
        }
    }
}

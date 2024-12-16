package com.example.b

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val optionOneButton: Button = findViewById(R.id.optionOneButton)
        val optionTwoButton: Button = findViewById(R.id.optionTwoButton)
        val hintTextView: TextView = findViewById(R.id.hintTextView)
         optionOneButton.setOnClickListener {
            Toast.makeText(this, "你選擇了詢問店員", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DialogueActivity::class.java)
            startActivity(intent)
        }
        optionTwoButton.setOnClickListener {
            Toast.makeText(this, "你選擇了直接走人", Toast.LENGTH_SHORT).show()
            hintTextView.text = "沒事的，再試試看！"
            hintTextView.visibility = TextView.VISIBLE
            android.os.Handler(Looper.getMainLooper()).postDelayed({
                hintTextView.visibility = TextView.GONE
            }, 2000)
        }
    }
}


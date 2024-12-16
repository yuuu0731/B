package com.example.b

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.b.R

class GameActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val dailyScenarioButton: Button = findViewById(R.id.dailyScenarioButton)
        val specialScenarioButton: Button = findViewById(R.id.specialScenarioButton)
        dailyScenarioButton.setOnClickListener {
            Toast.makeText(this, "進入日常情境", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }

        specialScenarioButton.setOnClickListener {
            Toast.makeText(this, "進入特殊情境", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SpecialScenarioActivity::class.java)
            startActivity(intent)
        }
    }
    fun showCompletionMessageAndPlayAudio() {
        Toast.makeText(this, "恭喜你完成這次對話挑戰", Toast.LENGTH_LONG).show()
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.congratulations)
            mediaPlayer?.start()
            mediaPlayer?.setOnCompletionListener {
                it.release()
            }
            Log.d("MediaPlayer", "音頻播放開始")
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "音頻播放錯誤", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}

package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.R.id
import com.example.quizapp.R.id.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView=findViewById(tvName)
        val tvScore:TextView=findViewById(tvScore)
        val btnFinish:Button=findViewById(FinalBtn)

        tvName.text=intent.getStringExtra(Constants.USER_NAME)
        val totalScore=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text="Your score is $correctAnswers out of $totalScore"

        btnFinish.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}
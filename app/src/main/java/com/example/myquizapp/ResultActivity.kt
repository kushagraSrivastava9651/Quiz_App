package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName:TextView=findViewById(R.id.tv_name)
        val tvScore:TextView=findViewById(R.id.score)
        val finished:Button=findViewById(R.id.Finish)
        tvName.text=intent.getStringExtra(Constants.USER_NAME)
         val total=intent.getIntExtra(Constants.total_ques,0)
        val correct=intent.getIntExtra(Constants.total_ans,0)
        tvScore.text="Your Score is $correct out of $total"
        finished.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}



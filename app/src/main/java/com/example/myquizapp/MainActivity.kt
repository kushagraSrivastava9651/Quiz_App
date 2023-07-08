package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button=findViewById(R.id.start_button)
        val userName:EditText=findViewById(R.id.user_name)
        btn.setOnClickListener {
        if(userName.text.toString().isEmpty()){
           Toast.makeText(this,"please enter your name",Toast.LENGTH_LONG).show()
        }
        else{
            val intent=Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME,userName.text.toString())
            startActivity(intent)
finish()
            }
        }
    }
}
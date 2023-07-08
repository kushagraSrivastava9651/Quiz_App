package com. example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myquizapp.Constants
import com.example.myquizapp.Question
import com.example.myquizapp.R

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {


private var numSelectedOption:Int=0
    private var currentPosT:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mselectedOption:Int=0
    private var textViewQuestions:TextView?=null

    private var correct:Int=0
    private var userName:String?=null

    private var progressBar:ProgressBar?=null
    private var progressText:TextView?=null
    private var ivImage:ImageView?=null
    private var btn:Button?=null

    private var option1:TextView?=null
    private var option2:TextView?=null
    private var option3:TextView?=null
    private var option4:TextView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

       userName=intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progress_bar)
        progressText=findViewById(R.id.tv_progress)
        btn=findViewById(R.id.submit)
        textViewQuestions=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)

        option1=findViewById(R.id.tv_option1)
        option2=findViewById(R.id.tv_option2)
        option3=findViewById(R.id.tv_option3)
        option4=findViewById(R.id.tv_option4)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btn?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![currentPosT - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosT
        progressText?.text = "$currentPosT/${(progressBar?.max)?.minus(1)}"
        textViewQuestions?.text = question.question
        option1?.text = question.optionOne
        option2?.text = question.optionTwo
        option3?.text = question.optionThree
        option4?.text = question.optionFour
        if(currentPosT== mQuestionList!!.size){
            btn?.text  ="FINISH"
        }
        else{
            btn?.text="SUBMIT"
        }
    }



 fun selectedOptionView(tv:TextView,selectedoption:Int){

    mselectedOption=selectedoption;
     defaultOptionView()

     mselectedOption=selectedoption
     tv.setTextColor(Color.parseColor("#FF2A9D8F"))
     tv.setTypeface(tv.typeface,Typeface.BOLD)
     tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
     numSelectedOption=1

 }

    fun defaultOptionView(){
        val option=ArrayList<TextView>()
        option1?.let {
            option.add(0,it)
        }
        option2?.let {
            option.add(1,it)
        }
        option3?.let {
            option.add(2,it)
        }
        option4?.let {
            option.add(3,it)
        }
        for(opt in option){
            opt.setTextColor(Color.parseColor("#FFE76F51"))
            opt.typeface= Typeface.DEFAULT
            opt.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }



    }

    override fun onClick(view: View?) {

         when(view?.id){
            R.id.tv_option1  ->{
                if(!btn?.text.toString().contains("GO TO NEXT QUESTION")) {
                    option1?.let {
                        selectedOptionView(it, 1)
                    }
                }
            }
            R.id.tv_option2->{
                if(!btn?.text.toString().contains("GO TO NEXT QUESTION")) {
                    option2?.let {
                        selectedOptionView(it, 2)
                    }
                }
            }
            R.id.tv_option3->{
                if(!btn?.text.toString().contains("GO TO NEXT QUESTION")) {
                    option3?.let {
                        selectedOptionView(it, 3)
                    }
                }
            }
            R.id.tv_option4->{
                if(!btn?.text.toString().contains("GO TO NEXT QUESTION")) {
                    option4?.let {
                        selectedOptionView(it, 4)
                    }
                }
            }
             R.id.submit->{
                 if(btn?.text.toString().contains("FINISH")){
                     val question=mQuestionList?.get(currentPosT-1)
                     if(question!!.correctAns!=mselectedOption){
                         answerView(mselectedOption,R.drawable.wrong_option_border_bg)
                         answerView(question.correctAns,R.drawable.correct_option_border_bg )
                     }
                     else{
                         answerView(question.correctAns,R.drawable.correct_option_border_bg )
                         correct++
                     }

                     currentPosT++
                     when {
                         currentPosT <= mQuestionList!!.size -> {
                             setQuestion()
                         }

                         else->{
                             val intent=Intent(this,ResultActivity::class.java)
                             intent.putExtra(Constants.USER_NAME,userName)
                             intent.putExtra(Constants.total_ans,correct)
                             intent.putExtra(Constants.total_ques,mQuestionList?.size)
                             startActivity(intent)
                             finish()

                         }

                     }
                     }
                 else if(btn?.text.toString().contains("GO TO NEXT QUESTION")){
                     currentPosT++
                     when {
                         currentPosT <= mQuestionList!!.size -> {
                             setQuestion()
                         }
                         else->{
                             val intent=Intent(this,ResultActivity::class.java)
                             intent.putExtra(Constants.USER_NAME,userName)
                             intent.putExtra(Constants.total_ans,correct)
                             intent.putExtra(Constants.total_ques,mQuestionList?.size)
                             startActivity(intent)
                             finish()
                         }
                     }
                 }
                 else if(numSelectedOption==0){
                      currentPosT++
                      when {
                          currentPosT <= mQuestionList!!.size -> {
                              setQuestion()
                          }

                              else->{
                                  val intent=Intent(this,ResultActivity::class.java)
                                  intent.putExtra(Constants.USER_NAME,userName)
                                  intent.putExtra(Constants.total_ans,correct)
                                  intent.putExtra(Constants.total_ques,mQuestionList?.size)
                                  startActivity(intent)
                                  finish()

                      }

                      }
                  }
                 else if(numSelectedOption==1){
                     val question=mQuestionList?.get(currentPosT-1)
                      if(question!!.correctAns!=mselectedOption){
                          answerView(mselectedOption,R.drawable.wrong_option_border_bg)
                          answerView(question.correctAns,R.drawable.correct_option_border_bg )
                      }
                      else{
                          answerView(question.correctAns,R.drawable.correct_option_border_bg )
                          correct++
                      }
                      

                      if(currentPosT==mQuestionList!!.size){
                          btn?.text="FINISH"
                      }
                      else{
                          btn?.text="GO TO NEXT QUESTION"
                      }


                  }
                      mselectedOption=0

        }
    }}

      fun answerView(ans:Int,drawableView:Int){
        when(ans){
            1->{
            option1?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                option2?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                option3?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                option4?.background=ContextCompat.getDrawable(this,drawableView)
            }

        }
    }
}
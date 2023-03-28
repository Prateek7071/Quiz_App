package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.media.tv.TvView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat
import kotlin.math.log

class QuizQuestionsActivity() : AppCompatActivity(), OnClickListener {

    private var currentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var selectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0

    private var pbProg: ProgressBar?=null
    private var tvProg: TextView?=null
    private var tvQuestion : TextView?=null
    private var imgview: ImageView?=null

    private var optionOne:TextView?=null
    private var optionTwo:TextView?=null
    private var optionThree:TextView?=null
    private var optionFour:TextView?=null

    private var btnSubmit:Button?=null
    private var mUserName:String?=null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)
        pbProg=findViewById(R.id.pbProg)
        tvProg=findViewById(R.id.tvProg)
        tvQuestion=findViewById(R.id.tvQuestion)
        imgview=findViewById(R.id.imgview)
        optionOne=findViewById(R.id.opt1)
        optionTwo=findViewById(R.id.opt2)
        optionThree=findViewById(R.id.opt3)
        optionFour=findViewById(R.id.opt4)
        btnSubmit=findViewById(R.id.btnSubmit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionView()
        var question = mQuestionList!![currentPosition-1]
        imgview?.setImageResource(question.image)
        pbProg?.progress = currentPosition
        tvProg?.text = "${currentPosition}/ ${pbProg?.max}"
        tvQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(currentPosition==mQuestionList!!.size){
            btnSubmit?.text=getString(R.string.Finish)
        }else{
            btnSubmit?.text=getString(R.string.Submit)
        }
    }

    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        selectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view:View?){
        when(view?.id){
            R.id.opt1->{
                optionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.opt2->{
                optionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.opt3->{
                optionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.opt4->{
                optionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btnSubmit->{
                if(selectedOptionPosition==0){
                    currentPosition++

                    when{
                        currentPosition<=mQuestionList!!.size-> {
                            setQuestion()
                        }else->{
                        val intent= Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val question=mQuestionList?.get(currentPosition -1)
                    if(question!!.correctAns!=selectedOptionPosition){
                        answerView(selectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAns,R.drawable.correct_option_border_bg)

                    if(currentPosition==mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }else{
                        btnSubmit?.text="Next Question"
                    }
                    selectedOptionPosition=0
                }
            }

        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                optionOne?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }2->{
                optionTwo?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }3->{
                optionThree?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }4->{
                optionFour?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }
}
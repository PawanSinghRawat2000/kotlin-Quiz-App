package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class questionActivity : AppCompatActivity() {

    var Name:String?=null
    var score =0

    private var questionList :ArrayList<questionData>?=null
    private var currentPos=1
    private var selectedOption=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(setData.name)

        questionList=setData.getQuestion()

        setQuestion()
        opt_1.setOnClickListener{
            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener{
            selectedOptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener{
            selectedOptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener{
            selectedOptionStyle(opt_4,4)
        }

        submitButton.setOnClickListener{
            if(selectedOption!=0){
                val que=questionList!![currentPos-1]
                if(selectedOption!=que.correct_ans){
                    setColor(selectedOption,R.drawable.wrongoption)
                }else{
                    score++
                }
                setColor(que.correct_ans,R.drawable.correctoptionstyle)

                if(currentPos==questionList!!.size){
                    submitButton.text="FINISH"
                }else submitButton.text="NEXT"
            }else{
                currentPos++

                when{
                    currentPos<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                            val intent = Intent(this,result::class.java)
                        intent.putExtra(setData.name,Name.toString())
                        intent.putExtra(setData.score, score.toString())
                        intent.putExtra("total_ques",questionList!!.size.toString())
                        startActivity(intent)
                    }
                }
            }
            selectedOption=0
        }

    }
    private fun setQuestion(){
        setOptionStyle()
        var que=questionList!![currentPos-1]
        question.text=que.question
        progressBar.progress=currentPos
        progressBar.max= questionList!!.size
        questionCount.text="${currentPos}"+"/"+"${progressBar.max}"

        opt_1.text=que.option_one
        opt_2.text=que.option_two
        opt_3.text=que.option_three
        opt_4.text=que.option_four
    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.optionstyle)
            op.typeface= Typeface.DEFAULT

        }

    }
    private fun selectedOptionStyle(view: TextView,opt:Int){
        setOptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
    private fun setColor(opt:Int,color:Int){
        when(opt){
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }
}
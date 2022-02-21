package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        var username=intent.getStringExtra(setData.name)
        val score=intent.getStringExtra(setData.score)
        val totalQues=intent.getStringExtra("total_ques")

        congo.text="CONGRATULATIONS ${username} !!"
        scoreTV.text="${score}"+"/"+"${totalQues}"

        finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}
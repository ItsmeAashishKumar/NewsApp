package com.example.rproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val title=intent.getStringExtra("heading")
        val content=intent.getStringExtra("newcontent")
        val picture=intent.getIntExtra("imageId",R.drawable.same)


        val titlet=findViewById<TextView>(R.id.head)
        val imaget=findViewById<ImageView>(R.id.pic)
        val contentt=findViewById<TextView>(R.id.summary)



        titlet.text=title
        contentt.text=content
        imaget.setImageResource(picture)

    }
}
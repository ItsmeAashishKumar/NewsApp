package com.example.rproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : AppCompatActivity() {

    lateinit var recycle:RecyclerView
    lateinit var newsArray:ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val news= arrayOf("Naatu Naatu' from SS Rajamouli's magnum opus wins Best Original Song at 95th Academy Awards","Jason Derulo covers waiter’s college fee for next semester, tips him \$5000 at restaurant in Omaha",
                "BBC sports coverage disrupted for second day over Gary Lineker Twitter row","Riyadh Air: Saudi Arabia to launch new national carrier","Same-sex marriages incompatible with 'Indian family' concept: Centre to SC",
        "Tyre burst is not an act of god, but negligence of driver, observes Bombay High Court")

        val pics= arrayOf(R.drawable.natu,R.drawable.jason,R.drawable.bbc,R.drawable.riyadh,R.drawable.same,R.drawable.tyre)

        val newsContent= arrayOf(getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),
        getString(R.string.news_content),getString(R.string.news_content))




        recycle=findViewById(R.id.rec)
       newsArray= arrayListOf<News>()
        recycle.layoutManager= LinearLayoutManager(this)

        for(i in news.indices){
            val news=News(pics[i],news[i],newsContent[i])
            newsArray.add(news)
        }

        var myAdapter=MyAdapter(newsArray,this)
        recycle.adapter=myAdapter
        myAdapter.setItemClickListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent= Intent(applicationContext,NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArray[position].title)
                intent.putExtra("imageId",newsArray[position].image)
                intent.putExtra("newscontent",newsArray[position].newsContent)
                startActivity(intent)


            }
        })

    }
}
package com.example.rproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val newsArray:ArrayList<News>,val context:Activity):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mylsitener:onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position:Int)
    }

    fun setItemClickListener(listener:onItemClickListener){
        mylsitener=listener
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): MyAdapter.MyViewHolder {
       val itemView=LayoutInflater.from(parent.context).inflate(R.layout.eaxhite,parent,false)
        return MyViewHolder(itemView,mylsitener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var current=newsArray[position]
        holder.title.text=current.title
        holder.image.setImageResource(current.image)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    class MyViewHolder(itemView : View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val title=itemView.findViewById<TextView>(R.id.title)
        val image=itemView.findViewById<ImageView>(R.id.img)

        init{
            itemView.setOnClickListener(){
                listener.onItemClick(adapterPosition )
            }
        }
    }
}
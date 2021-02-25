package com.example.lifestyle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class MainRvAdapter(val context: Context, val list: ArrayList<Model>) : RecyclerView.Adapter<MainRvAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MainRvAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_rv_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: MainRvAdapter.Holder, position: Int) {

        if(itemClick != null){
            holder?.itemView?.setOnClickListener{ v ->
                itemClick?.onClick(v, position)
            }
        }

        holder.bind(list[position], this.context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val photo = itemView?.findViewById<ImageView>(R.id.image_area)
        val title = itemView?.findViewById<TextView>(R.id.text_area)

        fun bind (model : Model, context: Context){
            title.text = model.title
        }
    }







}
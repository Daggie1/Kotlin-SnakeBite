package com.example.snakebite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView

class ResultsRecyclerAdapter(private val context: Context, private val snakeBites:ArrayList<SnakeBites>) :
    RecyclerView.Adapter<ResultsRecyclerAdapter.ViewHolder>( ) {
    val SNAKEBITE_POS="com.example.snakebite"

private val layoutInflater=LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView= layoutInflater.inflate(R.layout.item_result_list,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount()=
snakeBites.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val snakeBite=snakeBites[position]
        holder.snakeBitetitle?.text=snakeBite.title
        holder.snakeBiteDesc?.text=snakeBite.description
        holder.snakeBiteImage?.setImageResource(snakeBite.imagRes)
        holder.snakeBitePosistion=position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val snakeBitetitle=itemView.findViewById<TextView?>(R.id.snake_bite_title)
        val snakeBiteDesc=itemView.findViewById<TextView?>(R.id.snake_bite_desc)
        val snakeBiteImage=itemView.findViewById<ImageView?>(R.id.snake_bite_image)
        var snakeBitePosistion=0
        init {
            itemView?.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java) //TODO start a iffrent activity

                intent.putExtra(SNAKEBITE_POS,snakeBitePosistion)
            }
        }
    }
}
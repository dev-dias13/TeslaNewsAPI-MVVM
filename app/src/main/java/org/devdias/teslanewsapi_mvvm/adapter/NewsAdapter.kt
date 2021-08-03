package org.devdias.teslanewsapi_mvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.devdias.teslanewsapi_mvvm.R
import org.devdias.teslanewsapi_mvvm.model.NewsArticles
/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Adapter for Recycler View
 **/
class NewsAdapter (
    private val dataSet: List<NewsArticles>
    ): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val author: TextView = view.findViewById(R.id.author)
        val description: TextView = view.findViewById(R.id.description)
        val imgNews: ImageView = view.findViewById(R.id.imgNews)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_layout, viewGroup, false)

        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = dataSet[position].title
        holder.author.text = "Author: " + dataSet[position].author
        holder.description.text = dataSet[position].description
        Picasso.get().load(dataSet[position].urlToImage).into(holder.imgNews)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
package tn.sim.gamerapp.viewholders

import androidx.recyclerview.widget.RecyclerView
import tn.sim.gamerapp.databinding.ItemNewsBinding
import tn.sim.gamerapp.models.News

class NewsViewHolder(val itemNewsBinding: ItemNewsBinding)
    : RecyclerView.ViewHolder(itemNewsBinding.root){

    fun setData(news : News) {
        itemNewsBinding.newsImage.setImageResource(news.image)
        itemNewsBinding.newsTitle.text = news.title
        itemNewsBinding.newsDescription.text = news.description
    }
}
package tn.sim.gamerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import tn.sim.gamerapp.R
import tn.sim.gamerapp.databinding.ItemNewsBinding
import tn.sim.gamerapp.models.News
import tn.sim.gamerapp.viewholders.NewsViewHolder

class NewsAdapter(val news : List<News>) : RecyclerView.Adapter<NewsViewHolder>() {

    lateinit var binding: ItemNewsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context)
            , parent, false)

        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val new = news[position]

        binding.btnNewsShowMore.setOnClickListener {
            val snack = Snackbar.make(holder.itemView,"Coming soon :)", Snackbar.LENGTH_LONG)
                .setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            snack.show()
        }

        holder.setData(new)
    }
}
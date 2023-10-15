package tn.sim.gamerapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import tn.sim.gamerapp.R
import tn.sim.gamerapp.databinding.ItemGameBinding
import tn.sim.gamerapp.models.Game
import tn.sim.gamerapp.viewholders.GameViewHolder

class GameAdapter(val games : List<Game>, val isProfile: Boolean) : RecyclerView.Adapter<GameViewHolder>() {

    lateinit var binding: ItemGameBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {

        binding = ItemGameBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]

        binding.gameIcon.setOnClickListener {
            val snack = Snackbar.make(holder.itemView, "Coming soon :)", Snackbar.LENGTH_LONG)
                .setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            snack.show()
        }

        if (isProfile)
            binding.gameIcon.setImageResource(R.drawable.ic_bookmark)

        holder.setData(game)
        }
}

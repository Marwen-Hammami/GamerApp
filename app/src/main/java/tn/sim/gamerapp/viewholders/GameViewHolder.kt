package tn.sim.gamerapp.viewholders

import androidx.recyclerview.widget.RecyclerView
import tn.sim.gamerapp.databinding.ItemGameBinding
import tn.sim.gamerapp.models.Game

class GameViewHolder(val itemGameBinding: ItemGameBinding)
    : RecyclerView.ViewHolder(itemGameBinding.root){

    fun setData(game : Game) {
        itemGameBinding.gameImage.setImageResource(game.image)
        itemGameBinding.gameTitle.text = game.name
        itemGameBinding.gamePlateform.text = game.plateform
        itemGameBinding.gamePrice.text = game.price.toString()
    }

}
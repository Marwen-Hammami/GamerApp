package tn.sim.gamerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import tn.sim.gamerapp.R
import tn.sim.gamerapp.adapters.GameAdapter
import tn.sim.gamerapp.databinding.FragmentStoreBinding
import tn.sim.gamerapp.models.Game

class StoreFragment : Fragment() {

    private lateinit var binding : FragmentStoreBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentStoreBinding.inflate(layoutInflater)

        initRecyclerView()

        floatingBtnInit()

        return binding.root

    }

    fun initRecyclerView() {
        //init static data
        val listGames = arrayListOf<Game>(
            Game(R.drawable.game_box_gta6, "Grand Theft Auto 6", "PS5 Game", 70.0),
            Game(R.drawable.game_box_beamng, "GBeamNG.drive", "PCGame", 24.99),
            Game(R.drawable.game_box_gta6, "Grand Theft Auto 6", "PS5 Game", 70.0),
            Game(R.drawable.game_box_beamng, "BeamNG.drive", "PC Game", 24.99)
        )

        val gameAdapter = GameAdapter(listGames, false)
        binding.storeRV.adapter = gameAdapter
        binding.storeRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    fun floatingBtnInit() {
        binding.floatingActionButton.setOnClickListener {
            val snackError = Snackbar.make(binding.root,"Coming soon :)", Snackbar.LENGTH_LONG)
                .setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            snackError.show()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar)

        enableShoppingCartIcon(toolbar)

    }

    fun enableShoppingCartIcon(toolbar: MaterialToolbar) {
        val menu = toolbar.menu
        val cartIem = menu.findItem(R.id.cart)

        cartIem.isVisible = true
    }
}
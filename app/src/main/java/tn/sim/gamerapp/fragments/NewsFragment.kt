package tn.sim.gamerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.MaterialToolbar
import tn.sim.gamerapp.R
import tn.sim.gamerapp.adapters.NewsAdapter
import tn.sim.gamerapp.databinding.FragmentNewsBinding
import tn.sim.gamerapp.models.News


class NewsFragment : Fragment() {

    private lateinit var binding : FragmentNewsBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentNewsBinding.inflate(layoutInflater)

        initRecyclerView()

        return binding.root
    }

    fun initRecyclerView() {
        //init static data
        val listNews = arrayListOf<News>(
            News(R.drawable.game_banner_cs2, "Bienvenue chez vous", "Counter-Strike 2 est disponible ! Venez-y jeter un œil. Counter-Strike 2 marque le plus grand bond technique de toute l'histoire de la franchise et garantit aujourd'hui de..."),
            News(R.drawable.game_banner_payday3, "Tout va bien pour Payday 3", "Voilà quelques jours que Payday 3 a vu le jour, pour tous les fans de cette licence, mais également les amateurs de FPS en coopération. Chez JV, ce titre a reçu la note de 17/20 soulignant en points positifs les ..."),
            News(R.drawable.game_banner_cs2, "Bienvenue chez vous", "Counter-Strike 2 est disponible ! Venez-y jeter un œil. Counter-Strike 2 marque le plus grand bond technique de toute l'histoire de la franchise et garantit aujourd'hui de..."),
            News(R.drawable.game_banner_payday3, "Tout va bien pour Payday 3", "Voilà quelques jours que Payday 3 a vu le jour, pour tous les fans de cette licence, mais également les amateurs de FPS en coopération. Chez JV, ce titre a reçu la note de 17/20 soulignant en points positifs les ...")
        )

        val newsAdapter = NewsAdapter(listNews)
        binding.newsRV.adapter = newsAdapter
        binding.newsRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar)

        enableShoppingCartIcon(toolbar)

    }

    fun enableShoppingCartIcon(toolbar: MaterialToolbar) {
        val menu = toolbar.menu
        val cartIem = menu.findItem(R.id.cart)

        cartIem.isVisible = false
    }
}
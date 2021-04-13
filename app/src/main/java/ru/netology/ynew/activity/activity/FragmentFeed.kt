package ru.netology.ynew.activity.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.ynew.R
import ru.netology.ynew.activity.adapter.OnInterfactionListener
import ru.netology.ynew.activity.adapter.StocksAdapter
import ru.netology.ynew.activity.viewmodel.StocksViewModel
import ru.netology.ynew.databinding.FragmentFeedBinding

class FragmentFeed : Fragment() {
    private val viewModel: StocksViewModel by viewModels(
            ownerProducer = ::requireParentFragment
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)

        val adapter = StocksAdapter(object : OnInterfactionListener {
            override fun likeById(id: Int) {
                viewModel.likeById(id)
            }
        })

        binding.list.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner, { stocks ->
            adapter.submitList(stocks)
        })

        binding.buttonFavorites.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentFeed_to_fragmentFavorite)

        }
        return binding.root
    }
}


//этот метод используется для получения текстового запроса, который пользователь ввел  в поле запроса.
// Вы будете использовать это для поиска в своей базе данных и возврата результата.
//        val searchView: SearchView = findViewById(R.id.search_view)
//        val query: CharSequence = searchView.getQuery()

package ru.netology.ynew.activity.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.ynew.activity.adapter.OnInterfactionListener
import ru.netology.ynew.activity.adapter.StocksAdapter
import ru.netology.ynew.activity.viewmodel.StocksViewModel
import ru.netology.ynew.databinding.FragmentFavoriteBinding

class FragmentFavorite : Fragment() {
    private val viewModel: StocksViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        val adapter = StocksAdapter(object : OnInterfactionListener {
            override fun likeById(id: Int) {
                viewModel.likeById(id)
            }
        })
        binding.list.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner, { stocks ->
            adapter.submitList(stocks.filter { it.favorite })
        })

        binding.buttonStocks.setOnClickListener {
            findNavController().navigateUp()

        }
        return binding.root
    }


}
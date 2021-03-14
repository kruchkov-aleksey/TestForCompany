package com.example.testforcompany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.PokemonSearch
import com.example.testforcompany.data.repository.SearchRepository
import com.example.testforcompany.main.adapter.MainAdapter
import com.example.testforcompany.main.adapter.SearchAdapter
import com.example.testforcompany.main.viewmodel.MainViewModel
import com.example.testforcompany.main.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.viewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Search.newInstance] factory method to
 * create an instance of this fragment.
 */
class Search : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private val mainViewModel: MainViewModel by viewModel()
    private val searchViewModel: SearchViewModel by viewModel()
    private lateinit var adapter: SearchAdapter
    private val pokemons: ArrayList<PokemonSearch> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserverSearch()
        button.setOnClickListener{
            searchViewModel.fetchPokemon(editTextTextPersonName.toString())
            adapter.addAll(pokemons)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Search().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun setupUI(){
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = SearchAdapter(pokemons)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,(recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
    private fun setupObserverSearch(){
        searchViewModel.name = editTextTextPersonName.toString()
        searchViewModel.pokemons.observe(viewLifecycleOwner,{
            adapter.addAll(pokemons)
            adapter.notifyDataSetChanged()
        })
    }
}
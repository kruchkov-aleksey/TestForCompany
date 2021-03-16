package com.example.testforcompany

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.testforcompany.data.model.Employee
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.main.adapter.MainAdapter
import com.example.testforcompany.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.item_layout.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [Favorite.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Search : Fragment() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter
    private val pokemons: ArrayList<Pokemon> = arrayListOf()
    private val appDataBase: AppDataBase by inject()
    private val employeeDao: EmployeeDao by inject()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserverSearch()
        button.setOnClickListener{
            mainViewModel.fetchPokemons(editText.text.toString())
        }


    }

    private fun setupUI(){
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(pokemons)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,(recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
    private fun setupObserverSearch(){
        mainViewModel.pokemons.observe(viewLifecycleOwner,{
            mainViewModel.pokemons.value?.let { it1 -> adapter.addData(it1) }
            adapter.notifyDataSetChanged()
        })
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Favorite.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Favorite().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
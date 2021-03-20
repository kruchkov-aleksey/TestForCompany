package com.example.testforcompany.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompatSideChannelService
import androidx.recyclerview.widget.RecyclerView
import com.example.testforcompany.R
import com.example.testforcompany.data.model.Employee
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.main.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.item_layout.view.*
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel


class MainAdapter(private var pokemons: ArrayList<Pokemon>,val listener: RecyclerViewClickListener): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    inner class DataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(pokemon: Pokemon){
                itemView.nameView.text = pokemon.name
                itemView.switch_add.isChecked = pokemon.isFavorite
                itemView.switch_add.setOnCheckedChangeListener { buttonView, isChecked ->
                    pokemon.isFavorite = isChecked
                listener.onCheckedChangeListener(pokemon, isChecked)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.DataViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    fun addData(list: List<Pokemon>){
        pokemons = arrayListOf()
        pokemons.addAll(list)
    }

    interface RecyclerViewClickListener{
        fun onCheckedChangeListener(item: Pokemon, isChecked: Boolean)
    }
}
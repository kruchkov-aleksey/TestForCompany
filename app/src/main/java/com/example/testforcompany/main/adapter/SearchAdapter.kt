package com.example.testforcompany.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforcompany.R
import com.example.testforcompany.data.model.PokemonSearch
import kotlinx.android.synthetic.main.item_layout.view.*

class SearchAdapter(private val pokemonsSearch: ArrayList<PokemonSearch>): RecyclerView.Adapter<SearchAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(pokemonSearch: PokemonSearch){
            itemView.nameView.text = pokemonSearch.ability?.firstOrNull()?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(pokemonsSearch[position])
    }

    override fun getItemCount(): Int {
        return pokemonsSearch.size
    }
    fun addAll(list: List<PokemonSearch>){
        pokemonsSearch.addAll(list)
    }
}
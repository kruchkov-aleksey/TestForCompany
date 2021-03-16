package com.example.testforcompany.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testforcompany.R
import com.example.testforcompany.data.model.Pokemon
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private var pokemons: ArrayList<Pokemon>): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(pokemon: Pokemon){
            itemView.nameView.text = pokemon.name
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
}
package com.example.testforcompany.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testforcompany.R
import com.example.testforcompany.data.model.Employee
import com.example.testforcompany.data.model.Pokemon
import kotlinx.android.synthetic.main.item_layout.view.*

class DataElementsAdapter(private var employees: ArrayList<Employee>): RecyclerView.Adapter<DataElementsAdapter.DataViewHolder>(){
    inner class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(employee: Employee){
            itemView.nameView.text = employee.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataElementsAdapter.DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_database, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(employees[position])
    }

    override fun getItemCount(): Int {
        return employees.size
    }
    fun addData(list: List<Employee>){
        employees.addAll(list)
    }
}

package com.example.testforcompany

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testforcompany.data.model.Employee
import kotlinx.android.synthetic.main.item_layout.*
import org.koin.android.ext.android.inject

class ItemFragment: Fragment() {

    private val appDataBase: AppDataBase by inject()
    private val employeeDao: EmployeeDao by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.item_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switch_add.setOnCheckedChangeListener { buttonView, isChecked ->
            val employee: Employee? = null
            employee?.name = nameView.text.toString()
            if(isChecked){
                employee?.let { employeeDao.insert(it) }
            }else{
                employee?.let { employeeDao.delete(it) }
            }
        }
    }
}
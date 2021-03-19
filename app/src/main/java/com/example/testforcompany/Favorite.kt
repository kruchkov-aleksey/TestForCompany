package com.example.testforcompany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testforcompany.data.model.Employee
import com.example.testforcompany.main.adapter.DataElementsAdapter
import com.example.testforcompany.main.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.android.ext.android.inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Favorite.newInstance] factory method to
 * create an instance of this fragment.
 */
class Favorite : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val employeeDao: EmployeeDao by inject()
    private val dataViewModel: DataViewModel by inject()
    private lateinit var adapter: DataElementsAdapter
    private val employees: ArrayList<Employee> = arrayListOf()

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
        setupObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
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
    fun setupUI(){
        rvDateBase.layoutManager = LinearLayoutManager(context)
        adapter = DataElementsAdapter(employees)
        rvDateBase.addItemDecoration(
            DividerItemDecoration(
                rvDateBase.context, (rvDateBase.layoutManager as LinearLayoutManager).orientation
            )
        )
        rvDateBase.adapter = adapter
    }
    fun setupObserver(){
        dataViewModel.employees.observe(viewLifecycleOwner,{
            dataViewModel.employees.value?.let { it1 -> adapter.addData(it1) }
        })
    }
}
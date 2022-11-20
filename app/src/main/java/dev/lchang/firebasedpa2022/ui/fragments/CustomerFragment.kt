package dev.lchang.firebasedpa2022.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import dev.lchang.firebasedpa2022.R
import dev.lchang.firebasedpa2022.ui.fragments.database.CustomerEntity

class CustomerFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerFragment()
    }

    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =  inflater.inflate(R.layout.fragment_customer, container, false)
        val txtFName: EditText = view.findViewById(R.id.txtFName)
        val txtLName: EditText = view.findViewById(R.id.txtLName)
        val txtPNumber: EditText = view.findViewById(R.id.txtPNumber)
        val btnSaveRoom: Button = view.findViewById(R.id.btnSaveRoom)

        viewModel = ViewModelProvider(this)[CustomerViewModel::class.java]

        btnSaveRoom.setOnClickListener {
            viewModel.saveCustomer(
                CustomerEntity(
                    txtFName.text.toString(),
                    txtLName.text.toString(),
                    txtPNumber.text.toString()
                )
            )

        }


        return view
    }

    private fun addObserver(){
        val observer = Observer<List<CustomerEntity>> { customers ->
            if(customers!=null){
                var text = ""
                for (customer in customers){
                    text += "${customer.firstName} ${customer.lastName} ${customer.phoneNumber}"
                    Log.d("List customer", "List customer  is... $text")
                }
            }
        }
        viewModel.customers.observe(this, observer)
    }
}
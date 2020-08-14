package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_amount.*

class InputAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    val transactionViewModel: TransactionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        button_send.setOnClickListener(this)
        transactionViewModel.recipientName.observe(
            viewLifecycleOwner,
            Observer { setNameToTextView(it) })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewName.text = "To: " + arguments?.getString("username")
    }

    override fun onClick(v: View?) {
        when (v) {
            button_send -> {
                transactionViewModel.setAmount(amount_transfer.text.toString())
                navController.navigate(R.id.action_inputAmountFragment_to_confirmationFragment)
            }
        }
    }

    fun setNameToTextView(name: String) {
        viewName.text = "To: $name"
    }
}
package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_recipient.*

class InputRecipientFragment : Fragment(), View.OnClickListener {

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
        return inflater.inflate(R.layout.fragment_input_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        next_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
           next_button -> {
               transactionViewModel.setBankName(dropdown_bank.selectedItem.toString())
               transactionViewModel.setAccountNumber(recipient_account_text.text.toString())
               transactionViewModel.setRecipientName(recipient_name_text.text.toString())
               navController.navigate(R.id.action_inputRecipientFragment_to_inputAmountFragment)
           }
        }
    }
}
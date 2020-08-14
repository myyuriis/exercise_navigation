package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_confirmation.*

class ConfirmationFragment : Fragment() {

    val transactionViewModel: TransactionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transactionViewModel.recipientName.observe(
            viewLifecycleOwner,
            Observer { setNameToTextView(it) })
        transactionViewModel.bankName.observe(
            viewLifecycleOwner,
            Observer { setBankToTextView(it) })
        transactionViewModel.accountNumber.observe(
            viewLifecycleOwner,
            Observer { setAccountToTextView(it) })
        transactionViewModel.amount.observe(
            viewLifecycleOwner,
            Observer { setAmountToTextView(it) })
    }

    fun setNameToTextView(name: String) {
        sent_to.text = "Sent to $name"
    }

    fun setBankToTextView(bank: String) {
        bank_name.text = "Bank $bank"
    }

    fun setAccountToTextView(account: String) {
        account_number.text = "Account no. $account"
    }

    fun setAmountToTextView(amount: String) {
        amount_textView.text = "Rp. $amount"
    }
}
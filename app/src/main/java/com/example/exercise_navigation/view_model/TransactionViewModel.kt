package com.example.exercise_navigation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel: ViewModel() {
    val bankName: MutableLiveData<String> = MutableLiveData("")
    val accountNumber: MutableLiveData<String> = MutableLiveData("")
    val recipientName: MutableLiveData<String> = MutableLiveData("")
    val amount: MutableLiveData<String> = MutableLiveData("0")

    fun setBankName(inputBankName: String) {
        bankName.value = inputBankName
    }

    fun setAccountNumber(inputAccountNumber: String) {
        accountNumber.value = inputAccountNumber
    }

    fun setRecipientName(inputRecipientName: String) {
        recipientName.value = inputRecipientName
    }

    fun setAmount(inputAmount: String) {
        amount.value = inputAmount
    }
}
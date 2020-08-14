package com.example.exercise_navigation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel: ViewModel() {
    val bankName: MutableLiveData<String> = MutableLiveData("")
    val accountNumber: MutableLiveData<Int> = MutableLiveData(0)
    val recipientName: MutableLiveData<String> = MutableLiveData("")

}
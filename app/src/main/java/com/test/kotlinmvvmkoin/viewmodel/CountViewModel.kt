package com.test.kotlinmvvmkoin.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.test.kotlinmvvmkoin.dao.CounterDAO
import com.test.kotlinmvvmkoin.model.Counter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CountViewModel(private val counterDAO: CounterDAO): ViewModel() {

    var counter = ObservableField<String>("0")
    lateinit var count: Counter

    init {
        GlobalScope.launch {
            count = counterDAO.get()
            if (count == null) {
                count = Counter(null, 0)
                counterDAO.insert(count)
            }
            counter.set(count.counter.toString())
        }
    }

    fun increment() {
        GlobalScope.launch {
            count.counter++
            counter.set(count.counter.toString())
            counterDAO.update(count)
        }
    }

    private fun onError(throwable: Throwable) {
        throwable.printStackTrace()
        Log.e("increment", throwable.message)
    }
}
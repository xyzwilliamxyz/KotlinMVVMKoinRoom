package com.test.kotlinmvvmkoin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.kotlinmvvmkoin.databinding.ActivityMainBinding
import com.test.kotlinmvvmkoin.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val viewModel: CountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mad: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mad.viewModel = viewModel

        button.setOnClickListener {
            viewModel.increment()
        }
    }
}

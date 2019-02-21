package com.test.kotlinmvvmkoin

import android.app.Application
import androidx.room.Room
import com.test.kotlinmvvmkoin.dao.CounterDatabase
import com.test.kotlinmvvmkoin.viewmodel.CountViewModel
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class MyApplication: Application() {

    val myModule = module {
        viewModel { CountViewModel(get()) }

        single {
            Room.databaseBuilder(get(), CounterDatabase::class.java, "counter-db")
                .build()
        }

        single {
            get<CounterDatabase>().counterDAO()
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(myModule))
    }
}
package com.test.kotlinmvvmkoin.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.kotlinmvvmkoin.model.Counter

@Database(entities = [Counter::class], version = 1)
abstract class CounterDatabase: RoomDatabase() {

    abstract fun counterDAO(): CounterDAO
}
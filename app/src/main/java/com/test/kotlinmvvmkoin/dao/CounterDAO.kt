package com.test.kotlinmvvmkoin.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.test.kotlinmvvmkoin.model.Counter

@Dao
interface CounterDAO {

    @Query("SELECT * from counter")
    fun get(): Counter

    @Insert
    fun insert(counter: Counter)

    @Update
    fun update(counter: Counter)

    @Query("DELETE from counter")
    fun delete()
}
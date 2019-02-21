package com.test.kotlinmvvmkoin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter")
data class Counter(@PrimaryKey(autoGenerate = true) var id: Long?,
                   @ColumnInfo(name = "counter") var counter: Int)
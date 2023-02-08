package com.kemalakkus.kotlinmaps.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kemalakkus.kotlinmaps.model.Place

@Database(entities = [Place::class], version = 1)
abstract class PlaceDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
}
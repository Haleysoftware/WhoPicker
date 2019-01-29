package com.haleysoftware.whopicker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by haleysoft on 12/18/18.
 */
@Database(entities = [EpisodeItem::class], version = 1, exportSchema = false)
abstract class DrDatabase: RoomDatabase() {

    abstract fun drDao(): DrDao

    companion object {
        val DATABASE_NAME = "dr_database"

        @Volatile
        var dbInstance : DrDatabase? = null

        fun getDbInstance(context: Context) : DrDatabase {
            val tempInstance = dbInstance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                        DrDatabase::class.java, DATABASE_NAME).build()
                dbInstance = instance
                return instance
            }
        }
    }
}
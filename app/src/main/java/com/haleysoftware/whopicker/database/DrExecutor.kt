package com.haleysoftware.whopicker.database

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by haleysoft on 12/18/18.
 */
class DrExecutor(var diskIO: Executor) {

    fun diskIO(): Executor {
        return this.diskIO
    }

    companion object {
        @Volatile
        private var executorInstance: DrExecutor? = null

        fun getInstance(): DrExecutor {
            val tempInstance = executorInstance
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = DrExecutor(Executors.newSingleThreadExecutor())
                executorInstance = instance
                return instance
            }
        }
    }
}
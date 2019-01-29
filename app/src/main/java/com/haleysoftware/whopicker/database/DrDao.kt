package com.haleysoftware.whopicker.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Created by haleysoft on 12/18/18.
 */
@Dao
interface DrDao {

    /**
     * This is used to add all the items on first creation and adding new ones with updates.
     *
     * [episodeItem] The episode to add to the database.
     */
    @Insert
    fun insertEpisode(vararg episodeItem: EpisodeItem)

    /**
     * Updates the item in the database.
     *
     * [episodeItem] The episode with updated data.
     */
    @Update
    fun updateEpisode(vararg episodeItem: EpisodeItem)

    /**
     * Returns a single item from the database.
     *
     * [columnName] The column to use for the item selection.
     * [search]     The kind of episode the user wants to watch.
     *
     * @return The item from the database to display.
     */
    @Query("SELECT * FROM dr_database WHERE :columnName = :search ORDER BY Random() LIMIT 1")
    fun getEpisode(columnName: String, search: String): EpisodeItem
}
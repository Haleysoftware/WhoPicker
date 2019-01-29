package com.haleysoftware.whopicker.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

/**
 * Created by haleysoft on 12/15/18.
 */
@Entity (tableName = "dr_database")
data class EpisodeItem (@PrimaryKey @NotNull var rowId: Int,
                   var seasonNum: Int,
                   var episodeNum: Int,
                   var episodeName: String,
                   var drNum: Int,
                   var villainName: String,
                   var favorite: Boolean)
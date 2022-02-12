package ru.fylmr.poplibs_nov21.db.enitity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubUserEntity(
    @PrimaryKey val id: Long,
    val login: String,
    val avatarUrl: String,
    val reposUrl: String,
)

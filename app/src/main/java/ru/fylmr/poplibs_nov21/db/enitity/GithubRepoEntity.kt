package ru.fylmr.poplibs_nov21.db.enitity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = GithubUserEntity::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class GithubRepoEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val userId: Long
)

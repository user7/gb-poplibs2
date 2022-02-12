package ru.fylmr.poplibs_nov21.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.db.enitity.GithubRepoEntity

@Dao
interface ReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: GithubRepoEntity)

    @Query("SELECT * FROM GithubRepoEntity")
    fun getAll(): Single<List<GithubRepoEntity>>
}
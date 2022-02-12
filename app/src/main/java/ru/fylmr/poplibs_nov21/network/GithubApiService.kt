package ru.fylmr.poplibs_nov21.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel

interface GithubApiService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>

    @GET
    fun getRepos(@Url reposUrl: String): Single<List<GithubRepoModel>>
}
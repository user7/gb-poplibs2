package ru.fylmr.poplibs_nov21.domain.users

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel
import ru.fylmr.poplibs_nov21.network.GithubApiService

class GithubUsersRepository(private val githubApiService: GithubApiService) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApiService.getUsers()
    }
}
package ru.fylmr.poplibs_nov21.domain.users

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel

interface IGithubUsersRepository {

    fun getUsers(): Single<List<GithubUserModel>>
}
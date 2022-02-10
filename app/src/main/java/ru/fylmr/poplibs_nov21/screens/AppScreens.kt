package ru.fylmr.poplibs_nov21.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.fylmr.poplibs_nov21.ui.repo.RepoFragment
import ru.fylmr.poplibs_nov21.ui.repos.ReposFragment
import ru.fylmr.poplibs_nov21.ui.users.UsersFragment
import java.io.Serializable

object AppScreens {

    fun usersScreen(initModel: UsersScreenInitParams) = FragmentScreen {
        UsersFragment.newInstance(initModel)
    }

    fun reposScreen(initModel: ReposScreenInitParams) = FragmentScreen {
        ReposFragment.newInstance(initModel)
    }

    fun repoScreen(initModel: RepoScreenInitParams) = FragmentScreen {
        RepoFragment.newInstance(initModel)
    }
}

class UsersScreenInitParams : Serializable

data class ReposScreenInitParams(
    val url: String
) : Serializable

data class RepoScreenInitParams(
    val name: String,
    val forks: Int,
    val watchers: Int,
    val reposUrl: String,
) : Serializable

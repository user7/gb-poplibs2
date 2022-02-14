package ru.fylmr.poplibs_nov21.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel
import ru.fylmr.poplibs_nov21.ui.repos.ReposFragment
import ru.fylmr.poplibs_nov21.ui.users.UsersFragment

interface IScreens {

    fun usersScreen(): FragmentScreen
    fun reposScreen(user: GithubUserModel): FragmentScreen
}

class AppScreens : IScreens {

    override fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }

    override fun reposScreen(user: GithubUserModel) = FragmentScreen {
        ReposFragment.newInstance(user)
    }
}
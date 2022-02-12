package ru.fylmr.poplibs_nov21.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.fylmr.poplibs_nov21.model.GithubUserModel
import ru.fylmr.poplibs_nov21.ui.repos.ReposFragment
import ru.fylmr.poplibs_nov21.ui.users.UsersFragment

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }

    fun reposScreen(user: GithubUserModel) = FragmentScreen {
        ReposFragment.newInstance(user)
    }
}
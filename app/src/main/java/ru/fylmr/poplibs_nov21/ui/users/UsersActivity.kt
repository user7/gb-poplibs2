package ru.fylmr.poplibs_nov21.ui.users

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.fylmr.poplibs_nov21.databinding.ActivityMainBinding
import ru.fylmr.poplibs_nov21.domain.GithubUsersRepository
import ru.fylmr.poplibs_nov21.ui.users.adapter.UsersAdapter

class UsersActivity : MvpAppCompatActivity(), UsersView {

    private val presenter by moxyPresenter { UsersPresenter(GithubUsersRepository()) }

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(presenter.usersListPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usersRecycler.layoutManager = LinearLayoutManager(this)
        binding.usersRecycler.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }
}
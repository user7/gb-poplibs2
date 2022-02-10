package ru.fylmr.poplibs_nov21.ui.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.databinding.FragmentRepoBinding
import ru.fylmr.poplibs_nov21.domain.GithubReposRepository
import ru.fylmr.poplibs_nov21.network.ApiHolder
import ru.fylmr.poplibs_nov21.screens.RepoScreenInitParams
import ru.fylmr.poplibs_nov21.ui.base.BackButtonListener
import ru.fylmr.poplibs_nov21.ui.repos.ReposPresenter

class RepoFragment : MvpAppCompatFragment(), RepoView, BackButtonListener {

    private val presenter by moxyPresenter {
        RepoPresenter(
            App.instance.router,
            initModel,
        )
    }
    private var _binding: FragmentRepoBinding? = null
    private val binding get() = _binding!!

    private val initModel by lazy {
        requireArguments().getSerializable(RepoFragment.KEY_INIT_PARAMS) as RepoScreenInitParams
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun showData(repo: RepoScreenInitParams) {
        binding.name.text = "Name: ${repo.name}"
        binding.forks.text = "Forks: ${repo.forks}"
        binding.watchers.text = "Watchers: ${repo.watchers}"
    }

    companion object {
        private const val KEY_INIT_PARAMS = "INIT"

        fun newInstance(repo: RepoScreenInitParams): RepoFragment {
            return RepoFragment().apply {
                arguments = bundleOf(KEY_INIT_PARAMS to repo)
            }
        }
    }
}
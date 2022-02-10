package ru.fylmr.poplibs_nov21.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.databinding.FragmentReposBinding
import ru.fylmr.poplibs_nov21.domain.GithubReposRepository
import ru.fylmr.poplibs_nov21.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.network.ApiHolder
import ru.fylmr.poplibs_nov21.screens.ReposScreenInitParams
import ru.fylmr.poplibs_nov21.ui.base.BackButtonListener
import ru.fylmr.poplibs_nov21.ui.repos.adapter.ReposAdapter

class ReposFragment : MvpAppCompatFragment(), ReposView, BackButtonListener {

    private val presenter by moxyPresenter {
        ReposPresenter(
            App.instance.router,
            GithubReposRepository(ApiHolder.githubApiService),
            initModel
        )
    }

    private var _binding: FragmentReposBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        ReposAdapter { repo -> presenter.onRepoClicked(repo) }
    }

    private val initModel by lazy {
        requireArguments().getSerializable(KEY_INIT_PARAMS) as ReposScreenInitParams
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reposRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.reposRecycler.adapter = adapter
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun updateList(repos: List<GithubRepoModel>) {
        adapter.submitList(repos)
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val KEY_INIT_PARAMS = "KEY_INIT_PARAMS"

        fun newInstance(initModel: ReposScreenInitParams): ReposFragment {
            return ReposFragment().apply {
                arguments = bundleOf(KEY_INIT_PARAMS to initModel)
            }
        }
    }
}
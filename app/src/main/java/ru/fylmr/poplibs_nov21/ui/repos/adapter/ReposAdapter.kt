package ru.fylmr.poplibs_nov21.ui.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.fylmr.poplibs_nov21.databinding.ItemRepoBinding
import ru.fylmr.poplibs_nov21.model.GithubRepoModel

class ReposAdapter(
    private val itemClickListener: (GithubRepoModel) -> Unit,
) : ListAdapter<GithubRepoModel, ReposAdapter.RepoViewHolder>(GithubReposItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.showRepo(currentList[position])
    }

    inner class RepoViewHolder(private val vb: ItemRepoBinding) : RecyclerView.ViewHolder(vb.root) {

        fun showRepo(githubRepoModel: GithubRepoModel) {
            vb.root.setOnClickListener { itemClickListener(githubRepoModel) }
            vb.tvRepo.text = githubRepoModel.name
        }
    }
}

object GithubReposItemCallback : DiffUtil.ItemCallback<GithubRepoModel>() {

    override fun areItemsTheSame(oldItem: GithubRepoModel, newItem: GithubRepoModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GithubRepoModel, newItem: GithubRepoModel): Boolean {
        return oldItem == newItem
    }
}
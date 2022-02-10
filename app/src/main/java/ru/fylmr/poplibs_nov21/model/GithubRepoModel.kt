package ru.fylmr.poplibs_nov21.model

import com.google.gson.annotations.Expose

data class GithubRepoModel(
    @Expose
    val id: Long,

    @Expose
    val url: String? = null,

    @Expose
    val name: String? = null,

    @Expose
    val watchers: Int = 0,

    @Expose
    val forks: Int = 0,
)
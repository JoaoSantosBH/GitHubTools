package com.carrefour.desafio.android.githubtools.features.home.domain

import com.google.gson.annotations.SerializedName

data class HomeModel(

    val authorizationsUrl: String? = null,

    val codeSearchUrl: String? = null,

    val commitSearchUrl: String? = null,

    val currentUserAuthorizationsHtmlUrl: String? = null,

    val currentUserRepositoriesUrl: String? = null,

    val currentUserUrl: String? = null,

    val emailsUrl: String? = null,

    val emojisUrl: String? = null,

    val eventsUrl: String? = null,
    val feedsUrl: String? = null,
    val followersUrl: String? = null,
    val followingUrl: String? = null,
    val gistsUrl: String? = null,
    val hubUrl: String? = null,
    val issueSearchUrl: String? = null,
    val issuesUrl: String? = null,
    val keysUrl: String? = null,
    val labelSearchUrl: String? = null,
    val notificationsUrl: String? = null,
    val organizationRepositoriesUrl: String? = null,
    val organizationTeamsUrl: String? = null,
    val organizationUrl: String? = null,
    val publicGistsUrl: String? = null,
    val rateLimitUrl: String? = null,
    val repositorySearchUrl: String? = null,
    val repositoryUrl: String? = null,
    val starredGistsUrl: String? = null,
    val starredUrl: String? = null,
    val topicSearchUrl: String? = null,
    val userOrganizationsUrl: String? = null,
    val userRepositoriesUrl: String? = null,
    val userSearchUrl: String? = null,
    val userUrl: String? = null
)
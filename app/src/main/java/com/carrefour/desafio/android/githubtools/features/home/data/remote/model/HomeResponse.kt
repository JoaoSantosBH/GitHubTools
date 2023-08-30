package com.carrefour.desafio.android.githubtools.features.home.data.remote.model


import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("authorizations_url")
    val authorizationsUrl: String? = null,
    @SerializedName("code_search_url")
    val codeSearchUrl: String? = null,
    @SerializedName("commit_search_url")
    val commitSearchUrl: String? = null,
    @SerializedName("current_user_authorizations_html_url")
    val currentUserAuthorizationsHtmlUrl: String? = null,
    @SerializedName("current_user_repositories_url")
    val currentUserRepositoriesUrl: String? = null,
    @SerializedName("current_user_url")
    val currentUserUrl: String? = null,
    @SerializedName("emails_url")
    val emailsUrl: String? = null,
    @SerializedName("emojis_url")
    val emojisUrl: String? = null,
    @SerializedName("events_url")
    val eventsUrl: String? = null,
    @SerializedName("feeds_url")
    val feedsUrl: String? = null,
    @SerializedName("followers_url")
    val followersUrl: String? = null,
    @SerializedName("following_url")
    val followingUrl: String? = null,
    @SerializedName("gists_url")
    val gistsUrl: String? = null,
    @SerializedName("hub_url")
    val hubUrl: String? = null,
    @SerializedName("issue_search_url")
    val issueSearchUrl: String? = null,
    @SerializedName("issues_url")
    val issuesUrl: String? = null,
    @SerializedName("keys_url")
    val keysUrl: String? = null,
    @SerializedName("label_search_url")
    val labelSearchUrl: String? = null,
    @SerializedName("notifications_url")
    val notificationsUrl: String? = null,
    @SerializedName("organization_repositories_url")
    val organizationRepositoriesUrl: String? = null,
    @SerializedName("organization_teams_url")
    val organizationTeamsUrl: String? = null,
    @SerializedName("organization_url")
    val organizationUrl: String? = null,
    @SerializedName("public_gists_url")
    val publicGistsUrl: String? = null,
    @SerializedName("rate_limit_url")
    val rateLimitUrl: String? = null,
    @SerializedName("repository_search_url")
    val repositorySearchUrl: String? = null,
    @SerializedName("repository_url")
    val repositoryUrl: String? = null,
    @SerializedName("starred_gists_url")
    val starredGistsUrl: String? = null,
    @SerializedName("starred_url")
    val starredUrl: String? = null,
    @SerializedName("topic_search_url")
    val topicSearchUrl: String? = null,
    @SerializedName("user_organizations_url")
    val userOrganizationsUrl: String? = null,
    @SerializedName("user_repositories_url")
    val userRepositoriesUrl: String? = null,
    @SerializedName("user_search_url")
    val userSearchUrl: String? = null,
    @SerializedName("user_url")
    val userUrl: String? = null
)
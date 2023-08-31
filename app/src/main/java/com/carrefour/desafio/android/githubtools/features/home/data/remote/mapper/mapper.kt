package com.carrefour.desafio.android.githubtools.features.home.data.remote.mapper

import com.carrefour.desafio.android.githubtools.features.home.data.remote.model.HomeResponse
import com.carrefour.desafio.android.githubtools.features.home.domain.HomeModel

fun HomeResponse.toDomain() = HomeModel(
    authorizationsUrl = this.authorizationsUrl ,
    codeSearchUrl = this.codeSearchUrl ,
    commitSearchUrl = this.commitSearchUrl ,
    currentUserAuthorizationsHtmlUrl = this.currentUserAuthorizationsHtmlUrl ,
    currentUserRepositoriesUrl = this.currentUserRepositoriesUrl ,
    currentUserUrl = this.currentUserUrl ,
    emailsUrl = this.emailsUrl ,
    emojisUrl = this.emojisUrl ,
    eventsUrl = this.eventsUrl ,
    feedsUrl = this.feedsUrl ,
    followersUrl = this.followersUrl ,
    followingUrl = this.followingUrl ,
    gistsUrl = this.gistsUrl ,
    hubUrl = this.hubUrl ,
    issueSearchUrl = this.issueSearchUrl ,
    issuesUrl = this.issuesUrl ,
    keysUrl = this.keysUrl ,
    labelSearchUrl = this.labelSearchUrl ,
    notificationsUrl = this.notificationsUrl ,
    organizationRepositoriesUrl = this.organizationRepositoriesUrl ,
    organizationTeamsUrl = this.organizationTeamsUrl ,
    organizationUrl = this.organizationUrl ,
    publicGistsUrl = this.publicGistsUrl ,
    rateLimitUrl = this.rateLimitUrl ,
    repositorySearchUrl = this.repositorySearchUrl ,
    repositoryUrl = this.repositoryUrl ,
    starredGistsUrl = this.starredGistsUrl ,
    starredUrl = this.starredUrl ,
    topicSearchUrl = this.topicSearchUrl ,
    userOrganizationsUrl = this.userOrganizationsUrl ,
    userRepositoriesUrl = this.userRepositoriesUrl ,
    userSearchUrl = this.userSearchUrl ,
    userUrl = this.userUrl
)
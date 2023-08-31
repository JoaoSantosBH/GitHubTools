package com.carrefour.desafio.android.githubtools.features.listusers.data.remote.mapper

import com.carrefour.desafio.android.githubtools.features.listusers.data.remote.model.ListUsersResponse
import com.carrefour.desafio.android.githubtools.features.listusers.domain.ListUsersModel

fun List<ListUsersResponse>.toDomain():List<ListUsersModel>  {
    return this.map { it.toModel() }
}



fun ListUsersResponse.toModel() = ListUsersModel(
    login = this.login,
    id = this.id,
    nodeId = this.nodeId,
    avatarUrl = this.avatarUrl,
    gravatarId = this.gravatarId,
    url = this.url,
    htmlUrl = this.htmlUrl,
    followersUrl = this.followersUrl,
    followingUrl = this.followingUrl,
    gistsUrl = this.gistsUrl,
    starredUrl = this.starredUrl,
    subscriptionsUrl = this.subscriptionsUrl,
    organizationsUrl = this.organizationsUrl,
    reposUrl = this.reposUrl,
    eventsUrl = this.eventsUrl,
    receivedEventsUrl = this.receivedEventsUrl,
    type = this.type,
    siteAdmin = this.siteAdmin
)
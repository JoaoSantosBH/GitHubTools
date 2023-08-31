package com.carrefour.desafio.android.githubtools.features.user.data.remote.mapper

import com.carrefour.desafio.android.githubtools.features.user.data.remote.model.UserResponse
import com.carrefour.desafio.android.githubtools.features.user.domain.UserModel

fun UserResponse.toDomain() = UserModel(
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
    siteAdmin = this.siteAdmin,
    name = this.name,
    company = this.company,
    blog = this.blog,
    location = this.location,
    email = this.email,
    hireable = this.hireable,
    bio = this.bio,
    twitterUsername = this.twitterUsername,
    publicRepos = this.publicRepos,
    publicGists = this.publicGists,
    followers = this.followers,
    following = this.following,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt
)
package com.carrefour.desafio.android.githubtools.features.listusers.presentation

import com.carrefour.desafio.android.githubtools.features.listusers.domain.ListUsersModel

sealed class ListUsersEvent {
    object OnClickUserEvent : ListUsersEvent()
    object FetchListUsersDataEvent : ListUsersEvent()

    class SuccessFetchListUsersEvent(val list: List<ListUsersModel>) : ListUsersEvent()
    class OnErrorEvent(val msg: String) : ListUsersEvent()
}
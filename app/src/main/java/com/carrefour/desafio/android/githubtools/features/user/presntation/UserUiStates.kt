package com.carrefour.desafio.android.githubtools.features.user.presntation

import com.carrefour.desafio.android.githubtools.features.user.domain.UserModel

data class UserUiStates(
    val isLoading:Boolean = false,
    val userLogin:String = "",
    val user: UserModel = UserModel()
) {

    companion object {
        val Empty = UserUiStates()
    }
}

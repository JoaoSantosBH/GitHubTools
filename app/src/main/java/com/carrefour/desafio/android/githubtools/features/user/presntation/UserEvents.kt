package com.carrefour.desafio.android.githubtools.features.user.presntation

import com.carrefour.desafio.android.githubtools.features.user.domain.UserModel

sealed class UserEvents {
    object FetchUserData : UserEvents()
    class SuccessFetchingUserData(val userModel: UserModel) : UserEvents()

}

package com.carrefour.desafio.android.githubtools.core.utils.util
import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("message") val message: String?,
    @SerializedName("code") val code: String)

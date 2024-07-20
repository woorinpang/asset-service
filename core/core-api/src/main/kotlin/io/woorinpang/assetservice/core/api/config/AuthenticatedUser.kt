package io.woorinpang.assetservice.core.api.config

import io.woorinpang.assetservice.core.domain.user.User

data class AuthenticatedUser private constructor(
    val userId: Long,
    val email: String,
    val name: String,
    val role: String,
) {
    fun toUser(): User {
        return User.of(
            id = userId,
            email = email,
            name = name,
        )
    }
}
package io.woorinpang.assetservice.core.domain.user

data class User(
    val id: Long,
    val email: String,
    val name: String,
) {
    companion object {
        fun of(id: Long, email: String, name: String): User {
            return User(
                id = id,
                email = email,
                name = name,
            )
        }
    }
}
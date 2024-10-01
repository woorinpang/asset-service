package io.woorinpang.assetservice.core.domain.asset

enum class AssetType(
    val code: String,
    val description: String,
) {
    ELECTRONIC("ELECTRONIC", "전자기기"),
    ;

    companion object {
        fun findByCode(code: String): AssetType? = entries.find { it.code == code }
    }
}

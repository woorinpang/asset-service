package io.woorinpang.assetservice.core.api.controller.asset.request

import io.woorinpang.assetservice.core.api.support.error.CustomMethodArgumentNotValidException
import io.woorinpang.assetservice.core.api.support.error.FieldError
import io.woorinpang.assetservice.core.domain.asset.AssetType
import jakarta.validation.constraints.NotBlank

data class AppendAssetRequest(
    @field:NotBlank(message = "assetType 필수입니다.")
    val assetType: String? = null,
) {
    @Throws(CustomMethodArgumentNotValidException::class)
    fun validate() {
        val errors =
            mutableListOf<FieldError>().apply {
                if (AssetType.findByCode(assetType!!) == null) {
                    add(FieldError.of("assetType", "assetType 일치하지 않습니다."))
                }
            }

        if (errors.isNotEmpty()) throw CustomMethodArgumentNotValidException(errors)
    }

    fun toAssetType(): AssetType {
        return AssetType.valueOf(assetType!!)
    }
}

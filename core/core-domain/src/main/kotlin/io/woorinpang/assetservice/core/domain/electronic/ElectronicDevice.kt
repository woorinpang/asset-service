package io.woorinpang.assetservice.core.domain.electronic

import java.math.BigDecimal

data class ElectronicDevice private constructor(
    val manufacturer: String,
    val model: String?,
    val serialNumber: String?,
    val price: Price,
) {
    companion object {
        fun of(
            manufacturer: String,
            model: String?,
            serialNumber: String?,
            price: BigDecimal,
        ): ElectronicDevice =
            ElectronicDevice(
                manufacturer = manufacturer,
                model = model,
                serialNumber = serialNumber,
                price = Price.of(price),
            )
    }
}

package io.woorinpang.assetservice.core.api.controller.electronic.request

import io.woorinpang.assetservice.core.api.support.error.CustomMethodArgumentNotValidException
import io.woorinpang.assetservice.core.api.support.error.FieldError
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDevice
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceType
import io.woorinpang.assetservice.core.domain.electronic.Price
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero

data class ModifyElectronicDeviceRequest(
    @field:NotBlank(message = "manufacturer 필수입니다.")
    val manufacturer: String? = null,

    @field:NotBlank(message = "model 필수입니다.")
    val model: String? = null,

    @field:NotBlank(message = "serialNumber 필수입니다.")
    val serialNumber: String? = null,

    @field:NotNull(message = "price 필수입니다.")
    @field:PositiveOrZero(message = "price 0 이상의 값이어야 합니다.")
    val price: Long? = null,
) {
    @Throws(CustomMethodArgumentNotValidException::class)
    fun validate() {
        val errors = mutableListOf<FieldError>().apply {

        }
        if (errors.isNotEmpty()) throw CustomMethodArgumentNotValidException(errors)
    }

    fun toElectronicDevice(): ElectronicDevice {
        return ElectronicDevice.of(
            manufacturer = manufacturer!!,
            model = model!!,
            serialNumber = serialNumber!!,
            price = Price.of(price!!),
        )
    }
}

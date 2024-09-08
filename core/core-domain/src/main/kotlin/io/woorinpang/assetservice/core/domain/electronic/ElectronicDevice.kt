package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntity

data class ElectronicDevice private constructor(
    val manufacturer: String,
    val model: String,
    val serialNumber: String,
    val price: Price,
) {
    companion object {
        fun of(
            manufacturer: String,
            model: String,
            serialNumber: String,
            price: Price,
        ): ElectronicDevice {
            return ElectronicDevice(
                manufacturer = manufacturer,
                model = model,
                serialNumber = serialNumber,
                price = price,
            )
        }
    }

    fun toEntity(
        assetId: Long,
        type: ElectronicDeviceType,
        user: String,
    ): ElectronicDeviceEntity {
        return ElectronicDeviceEntity.of(
            assetId = assetId,
            type = type.name,
            manufacturer = manufacturer,
            model = model,
            serialNumber = serialNumber,
            price = price.value,
            createdBy = user,
        )
    }
}

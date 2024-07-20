package io.woorinpang.assetservice.core.api.controller.electronic.request

import io.woorinpang.assetservice.core.domain.electronic.ElectronicDevice
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceTarget
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceType
import io.woorinpang.assetservice.core.domain.electronic.Price

data class AppendElectronicDeviceRequest private constructor(
    val electronicDeviceType: String,
    val manufacturer: String,
    val model: String,
    val serialNumber: String,
    val price: Long,
) {
    fun toTarget(assetId: Long) = ElectronicDeviceTarget(assetId, ElectronicDeviceType.valueOf(electronicDeviceType))

    fun toElectronicDevice(): ElectronicDevice {
        return ElectronicDevice.of(
            manufacturer = manufacturer,
            model = model,
            serialNumber = serialNumber,
            price = Price.of(price),
        )
    }
}

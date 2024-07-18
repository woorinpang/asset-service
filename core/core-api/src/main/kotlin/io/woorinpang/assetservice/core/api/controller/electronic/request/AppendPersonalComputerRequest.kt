package io.woorinpang.assetservice.core.api.controller.electronic.request

import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceTarget
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceType
import io.woorinpang.assetservice.core.domain.electronic.PersonalComputer

data class AppendPersonalComputerRequest private constructor(
    val manufacturer: String,
    val model: String,
    val operationSystem: String,
    val processor: String,
    val memory: String,
    val storage: String,
    val graphicsCard: String,
    val serialNumber: String,
    val price: Int,
) {
    fun toTarget(assetId: Long) = ElectronicDeviceTarget(assetId, ElectronicDeviceType.PC)

    fun toPersonalComputer(): PersonalComputer {
        return PersonalComputer.of(
            manufacturer = manufacturer,
            model = model,
            operationSystem = operationSystem,
            processor = processor,
            memory = memory,
            storage = storage,
            graphicsCard = graphicsCard,
            serialNumber = serialNumber,
            price = price
        )
    }
}

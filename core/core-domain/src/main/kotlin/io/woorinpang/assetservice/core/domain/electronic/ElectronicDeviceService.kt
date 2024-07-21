package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Component

@Component
class ElectronicDeviceService(
    val electronicDeviceAppender: ElectronicDeviceAppender,
    val electronicDeviceRemover: ElectronicDeviceRemover,
    val electronicDeviceModifier: ElectronicDeviceModifier,
    val electronicDeviceValidator: ElectronicDeviceValidator,
) {
    fun appendElectronicDevice(
        assetId: Long,
        type: ElectronicDeviceType,
        electronicDevice: ElectronicDevice,
        user: User,
    ): Long {
        return electronicDeviceAppender.append(assetId, type, electronicDevice, user)
    }

    fun modifyElectronicDevice(
        target: ElectronicDeviceTarget,
        electronicDevice: ElectronicDevice,
        user: User,
    ) {
        electronicDeviceValidator.validCreatedBy(target, user)
        electronicDeviceModifier.modify(target, electronicDevice, user)
    }

    fun removeElectronicDevice(
        target: ElectronicDeviceTarget,
        user: User,
    ) {
        electronicDeviceValidator.validCreatedBy(target, user)
        electronicDeviceRemover.remove(target, user)
    }
}
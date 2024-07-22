package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.asset.AssetTarget
import io.woorinpang.assetservice.core.domain.asset.AssetType
import io.woorinpang.assetservice.core.domain.asset.AssetValidator
import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Component

@Component
class ElectronicDeviceService(
    val electronicDeviceAppender: ElectronicDeviceAppender,
    val electronicDeviceRemover: ElectronicDeviceRemover,
    val electronicDeviceModifier: ElectronicDeviceModifier,
    val electronicDeviceValidator: ElectronicDeviceValidator,
    val assetValidator: AssetValidator,
) {
    fun appendElectronicDevice(
        assetId: Long,
        user: User,
        type: ElectronicDeviceType,
        electronicDevice: ElectronicDevice,
    ): Long {
        assetValidator.validUserAsset(AssetTarget(assetId), user, AssetType.ELECTRONIC)
        return electronicDeviceAppender.append(assetId, type, electronicDevice, user)
    }

    fun modifyElectronicDevice(
        target: ElectronicDeviceTarget,
        user: User,
        electronicDevice: ElectronicDevice,
    ) {
        electronicDeviceValidator.validCreatedBy(target, user)
        electronicDeviceModifier.modify(target, user, electronicDevice)
    }

    fun removeElectronicDevice(
        target: ElectronicDeviceTarget,
        user: User,
    ) {
        electronicDeviceValidator.validCreatedBy(target, user)
        electronicDeviceRemover.remove(target, user)
    }
}
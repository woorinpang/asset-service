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
        type: ElectronicDeviceType,
        electronicDevice: ElectronicDevice,
        user: User,
    ): Long {
        assetValidator.validAssetIsElectronic(AssetTarget(assetId), AssetType.ELECTRONIC)
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
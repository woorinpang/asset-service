package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User

interface ElectronicDeviceRepository {
    fun append(assetId: Long, type: ElectronicDeviceType, electronicDevice: ElectronicDevice, user: User): Long

    fun findElectronicDevice(electronicDeviceId: Long): ElectronicDevice?

    fun modifyElectronicDevice(electronicDeviceId: Long, user: User, electronicDevice: ElectronicDevice)

    fun removeElectronicDevice(electronicDeviceId: Long, user: User)
}

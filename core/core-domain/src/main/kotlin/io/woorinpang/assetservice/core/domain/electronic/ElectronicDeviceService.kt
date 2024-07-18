package io.woorinpang.assetservice.core.domain.electronic

import org.springframework.stereotype.Component

@Component
class ElectronicDeviceService(
    val personalComputerAppender: PersonalComputerAppender
) {
    fun appendPersonalComputer(
        target: ElectronicDeviceTarget,
        personalComputer: PersonalComputer,
    ): Long {
        return personalComputerAppender.append(target, personalComputer)
    }

    fun appendMobilePhone(
        target: ElectronicDeviceTarget,
        mobilePhone: MobilePhone,
    ) {

    }
}
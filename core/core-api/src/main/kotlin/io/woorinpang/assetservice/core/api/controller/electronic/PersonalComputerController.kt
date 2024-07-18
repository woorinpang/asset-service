package io.woorinpang.assetservice.core.api.controller.electronic

import io.woorinpang.assetservice.core.api.controller.electronic.request.AppendPersonalComputerRequest
import io.woorinpang.assetservice.core.api.support.response.ApiResponse
import io.woorinpang.assetservice.core.api.support.response.DefaultIdResponse
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/assets/{assetId}/personal-computers")
class PersonalComputerController(
    val electronicDeviceService: ElectronicDeviceService
) {

    @RequestMapping
    fun appendPersonalComputer(
        @PathVariable assetId: Long,
        @RequestBody @Valid request: AppendPersonalComputerRequest
    ): ApiResponse<DefaultIdResponse> {
        val successId = electronicDeviceService.personalComputerAppender.append(
            request.toTarget(assetId),
            request.toPersonalComputer()
        )
        return ApiResponse.success(DefaultIdResponse(successId))
    }
}
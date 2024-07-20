package io.woorinpang.assetservice.core.api.controller.electronic

import io.woorinpang.assetservice.core.api.controller.electronic.request.AppendElectronicDeviceRequest
import io.woorinpang.assetservice.core.api.support.response.ApiResponse
import io.woorinpang.assetservice.core.api.support.response.DefaultIdResponse
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceService
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceTarget
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/assets/{assetId}/electronic-devices")
class ElectronicDeviceController(
    val electronicDeviceService: ElectronicDeviceService
) {

    @PostMapping
    fun appendElectronicDevice(
        @PathVariable assetId: Long,
        @RequestBody @Valid request: AppendElectronicDeviceRequest
    ): ApiResponse<DefaultIdResponse> {
        val successId = electronicDeviceService.electronicDeviceAppender.append(assetId, request.toElectronicDevice())
        return ApiResponse.success(DefaultIdResponse(successId))
    }

    @DeleteMapping("/{electronicDeviceId}")
    fun deleteElectronicDevice(
        @PathVariable assetId: Long,
        @PathVariable electronicDeviceId: Long
    ): ApiResponse<Any> {
        electronicDeviceService.removeElectronicDevice(ElectronicDeviceTarget(electronicDeviceId))
        return ApiResponse.success()
    }
}
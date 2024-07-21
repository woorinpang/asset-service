package io.woorinpang.assetservice.core.api.controller.electronic

import io.woorinpang.assetservice.core.api.config.AuthenticatedUser
import io.woorinpang.assetservice.core.api.controller.electronic.request.AppendElectronicDeviceRequest
import io.woorinpang.assetservice.core.api.controller.electronic.request.ModifyElectronicDeviceRequest
import io.woorinpang.assetservice.core.api.support.response.ApiResponse
import io.woorinpang.assetservice.core.api.support.response.DefaultIdResponse
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceService
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceTarget
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assets/{assetId}/electronic-devices")
class ElectronicDeviceController(
    val electronicDeviceService: ElectronicDeviceService,
) {
    @PostMapping
    fun appendElectronicDevice(
        @RequestAttribute("authenticatedUser") authenticatedUser: AuthenticatedUser,
        @PathVariable assetId: Long,
        @RequestBody @Valid request: AppendElectronicDeviceRequest,
    ): ApiResponse<DefaultIdResponse> {
        request.validate()
        val successId = electronicDeviceService.appendElectronicDevice(assetId, request.toType(), request.toElectronicDevice(), authenticatedUser.toUser())
        return ApiResponse.success(DefaultIdResponse(successId))
    }

    @PutMapping("/{electronicDeviceId}")
    fun updateElectronicDevice(
        @RequestAttribute("authenticatedUser") authenticatedUser: AuthenticatedUser,
        @PathVariable assetId: Long,
        @PathVariable electronicDeviceId: Long,
        @RequestBody @Valid request: ModifyElectronicDeviceRequest,
    ): ApiResponse<Any> {
        request.validate()
        electronicDeviceService.modifyElectronicDevice(ElectronicDeviceTarget(electronicDeviceId), request.toElectronicDevice(), authenticatedUser.toUser())
        return ApiResponse.success()
    }

    @DeleteMapping("/{electronicDeviceId}")
    fun deleteElectronicDevice(
        @RequestAttribute("authenticatedUser") authenticatedUser: AuthenticatedUser,
        @PathVariable assetId: Long,
        @PathVariable electronicDeviceId: Long,
    ): ApiResponse<Any> {
        electronicDeviceService.removeElectronicDevice(ElectronicDeviceTarget(electronicDeviceId), authenticatedUser.toUser())
        return ApiResponse.success()
    }
}
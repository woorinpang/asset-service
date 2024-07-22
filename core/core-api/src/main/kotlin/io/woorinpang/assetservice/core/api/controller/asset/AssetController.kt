package io.woorinpang.assetservice.core.api.controller.asset

import io.woorinpang.assetservice.core.api.config.AuthenticatedUser
import io.woorinpang.assetservice.core.api.controller.asset.request.AppendAssetRequest
import io.woorinpang.assetservice.core.api.controller.asset.response.FindAssetResponse
import io.woorinpang.assetservice.core.api.support.response.ApiResponse
import io.woorinpang.assetservice.core.api.support.response.DefaultIdResponse
import io.woorinpang.assetservice.core.domain.asset.AssetService
import io.woorinpang.assetservice.core.domain.asset.AssetTarget
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assets")
class AssetController(
    val assetService: AssetService,
) {
    @PostMapping
    fun appendAsset(
        @RequestAttribute("authenticatedUser") authenticatedUser: AuthenticatedUser,
        @RequestBody @Valid request: AppendAssetRequest,
    ): ApiResponse<DefaultIdResponse> {
        request.validate()
        val successId = assetService.appendAsset(authenticatedUser.toUser(), request.toAssetType())
        return ApiResponse.success(DefaultIdResponse(successId))
    }

    @GetMapping("/{assetId}")
    fun findAsset(
        @PathVariable assetId: Long,
    ): ApiResponse<FindAssetResponse> {
        return ApiResponse.success(FindAssetResponse.of(assetService.findAsset(AssetTarget(assetId))))
    }

    @DeleteMapping("/{assetId}")
    fun deleteAsset(
        @RequestAttribute("authenticatedUser") authenticatedUser: AuthenticatedUser,
        @PathVariable assetId: Long,
    ): ApiResponse<Any> {
        assetService.deleteAsset(AssetTarget(assetId), authenticatedUser.toUser())
        return ApiResponse.success()
    }
}

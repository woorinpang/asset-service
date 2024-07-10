package io.woorinpang.assetservice.core.api.controller.asset

import io.woorinpang.assetservice.core.api.controller.asset.request.AppendAssetRequest
import io.woorinpang.assetservice.core.api.controller.asset.response.FindAssetResponse
import io.woorinpang.assetservice.core.api.support.response.ApiResponse
import io.woorinpang.assetservice.core.api.support.response.DefaultIdResponse
import io.woorinpang.assetservice.core.domain.asset.AssetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assets")
class AssetController(
    val assetService: AssetService,
) {
    @PostMapping
    fun appendAsset(
        @RequestBody request: AppendAssetRequest,
    ): ApiResponse<DefaultIdResponse> {
        val successId = assetService.appendAsset(request.assetType)
        return ApiResponse.success(DefaultIdResponse(successId))
    }

    @GetMapping("/{assetId}")
    fun findAsset(
        @PathVariable assetId: Long,
    ): ApiResponse<FindAssetResponse> {
        return ApiResponse.success(FindAssetResponse.of(assetService.findAsset(assetId)))
    }

    @DeleteMapping("/{assetId}")
    fun deleteAsset(
        @PathVariable assetId: Long,
    ): ApiResponse<Any> {
        assetService.deleteAsset(assetId)
        return ApiResponse.success()
    }
}

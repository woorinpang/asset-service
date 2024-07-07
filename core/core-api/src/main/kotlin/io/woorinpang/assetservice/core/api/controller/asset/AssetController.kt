package io.woorinpang.assetservice.core.api.controller.asset

import io.woorinpang.assetservice.core.api.controller.asset.request.AppendAssetRequest
import io.woorinpang.assetservice.core.domain.asset.AssetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/assets")
class AssetController(
    val assetService: AssetService,
) {
    @PostMapping
    fun createAsset(
        @RequestBody request: AppendAssetRequest,
    ): ResponseEntity<Long> {
        val result = assetService.appendAsset(request.assetType)
        return ResponseEntity.ok().body(result)
    }
}

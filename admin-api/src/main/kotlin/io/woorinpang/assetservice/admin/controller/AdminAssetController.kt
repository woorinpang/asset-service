package io.woorinpang.assetservice.admin.controller

import io.woorinpang.assetservice.admin.service.AdminAssetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/assets")
class AdminAssetController(
    val adminAssetService: AdminAssetService,
) {
    @GetMapping
    fun findAssets(): ResponseEntity<String> {
        return ResponseEntity.ok().body("asset-service")
    }
}
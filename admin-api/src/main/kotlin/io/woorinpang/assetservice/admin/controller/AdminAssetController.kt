package io.woorinpang.assetservice.admin.controller

import io.woorinpang.assetservice.admin.support.page.AdminPageable
import io.woorinpang.assetservice.admin.support.response.AdminApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@RequestMapping("/admin/assets")
class AdminAssetController {
    @GetMapping
    fun findAssets(
        pageable: AdminPageable
    ): ResponseEntity<AdminApiResponse<Any>> {

        return ResponseEntity.ok().body(AdminApiResponse.success())
    }
}
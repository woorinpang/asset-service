package io.woorinpang.assetservice.core.domain.asset

import org.springframework.data.jpa.repository.JpaRepository

interface AssetRepository : JpaRepository<Asset, Long> {
}
package io.woorinpang.assetservice.storage.db.core.asset

import org.springframework.data.jpa.repository.JpaRepository

interface AssetJpaRepository : JpaRepository<AssetEntity, Long>

package io.woorinpang.assetservice.storage.db.core.asset

import org.springframework.data.jpa.repository.JpaRepository

interface AssetEntityJpaRepository : JpaRepository<AssetEntity, Long>

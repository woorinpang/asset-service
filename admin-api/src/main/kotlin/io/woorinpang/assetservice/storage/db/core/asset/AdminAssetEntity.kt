package io.woorinpang.assetservice.storage.db.core.asset

import jakarta.persistence.*

@Entity
@Table(name = "Asset")
class AdminAssetEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

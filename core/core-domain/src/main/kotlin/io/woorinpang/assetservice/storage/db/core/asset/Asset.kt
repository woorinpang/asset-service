package io.woorinpang.assetservice.storage.db.core.asset

import io.woorinpang.assetservice.core.domain.asset.AssetType
import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Asset(
    @Column
    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "assetType")
    private var type: AssetType,

    @Column(name = "deleted")
    private var deleted: Boolean
) : BaseEntity() {
    companion object {
        fun of(userId: Long, type: AssetType): Asset {
            return Asset(
                userId = userId,
                type = type,
                deleted = false
            )
        }
    }

    fun delete() {
        this.deleted = true
    }

    fun modify(assetType: AssetType) {
        this.type = assetType
    }
}

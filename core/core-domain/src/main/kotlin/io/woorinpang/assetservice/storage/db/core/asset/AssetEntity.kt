package io.woorinpang.assetservice.storage.db.core.asset

import io.woorinpang.assetservice.core.domain.asset.AssetType
import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "asset")
class AssetEntity(
    @Column
    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "assetType")
    val type: AssetType,

    @Column(name = "deleted")
    private var deleted: Boolean
) : BaseEntity() {
    companion object {
        fun of(userId: Long, type: AssetType): AssetEntity {
            return AssetEntity(
                userId = userId,
                type = type,
                deleted = false
            )
        }
    }

    fun delete() {
        this.deleted = true
    }
}
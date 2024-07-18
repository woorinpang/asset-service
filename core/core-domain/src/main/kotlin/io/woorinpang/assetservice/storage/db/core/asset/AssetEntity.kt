package io.woorinpang.assetservice.storage.db.core.asset

import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "Asset")
class AssetEntity(
    @Column
    val userId: Long,

    @Column(name = "assetType")
    val type: String,

    @Column(name = "deleted")
    private var deleted: Boolean
) : BaseEntity() {
    companion object {
        fun of(userId: Long, type: String): AssetEntity {
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

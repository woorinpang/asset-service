package io.woorinpang.assetservice.storage.db.core.asset

import io.woorinpang.assetservice.core.enums.AssetType
import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "Asset")
class AssetEntity(
    @Column
    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "assetType")
    val type: AssetType,

    @Column(name = "deleted")
    var deleted: Boolean = false,

    @Column(name = "createdBy")
    val createdBy: Long,

    @Column(name = "updatedBy")
    var updatedBy: Long,
) : BaseEntity() {
    companion object {
        fun of(userId: Long, type: AssetType, createdBy: Long): AssetEntity = AssetEntity(
            userId = userId,
            type = type,
            createdBy = createdBy,
            updatedBy = createdBy,
        )
    }

    fun delete(updatedBy: Long) {
        this.deleted = true
        this.updatedBy = updatedBy
    }

    fun equalCreatedBy(createdBy: Long): Boolean = this.createdBy == createdBy

    fun equalAssetType(type: AssetType): Boolean = this.type == type

    fun equalUserId(id: Long): Boolean = this.userId == id
}

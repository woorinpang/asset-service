package io.woorinpang.assetservice.storage.db.core.asset

import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Suppress("ktlint:standard:no-blank-line-in-list")
@Entity
@Table(name = "Asset")
class AssetEntity(
    @Column
    val userId: Long,

    @Column(name = "assetType")
    val type: String,

    @Column(name = "deleted")
    private var deleted: Boolean = false,

    @Column(name = "createdBy", columnDefinition = "varchar(60) not null comment '생성자'")
    val createdBy: String,

    @Column(name = "updatedBy", columnDefinition = "varchar(60) not null comment '수정자'")
    var updatedBy: String,
) : BaseEntity() {
    companion object {
        fun of(
            userId: Long,
            type: String,
            createdBy: String,
        ): AssetEntity {
            return AssetEntity(
                userId = userId,
                type = type,
                createdBy = createdBy,
                updatedBy = createdBy,
            )
        }
    }

    fun delete(updatedBy: String) {
        this.deleted = true
        this.updatedBy = updatedBy
    }

    fun equalCreatedBy(createdBy: String): Boolean {
        return this.createdBy == createdBy
    }

    fun equalAssetType(type: String): Boolean {
        return this.type == type
    }

    fun equalUserId(id: Long): Boolean {
        return this.userId == id
    }

    fun isDeleted(): Boolean {
        return this.deleted
    }
}

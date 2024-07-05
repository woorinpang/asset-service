package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Asset (
    @Column
    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "assetType")
    val type: AssetType
) : BaseEntity()


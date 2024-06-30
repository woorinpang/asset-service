package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.AssetType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Asset (
    @Column
    val userId: Long,

    @Column(name = "assetName")
    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "assetType")
    val type: AssetType
) : BaseEntity()


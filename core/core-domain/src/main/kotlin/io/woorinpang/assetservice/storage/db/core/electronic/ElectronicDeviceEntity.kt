package io.woorinpang.assetservice.storage.db.core.electronic

import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "ElectronicDevice")
class ElectronicDeviceEntity (
    @Column(name = "assetId", columnDefinition = "bigint not null comment '자산 고유번호'")
    val assetId: Long,

    @Column(name = "electronicDeviceType", columnDefinition = "varchar(30) not null comment '전자기기 타입'")
    val type: String,

) : BaseEntity()

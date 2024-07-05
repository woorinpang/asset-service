package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.support.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class ElectronicDevice(
    @Column(name = "name", columnDefinition = "varchar(60) not null comment '전자기기명'")
    val name : String,

    @Enumerated(EnumType.STRING)
    @Column(name = "electronicDeviceType", columnDefinition = "varchar(30) not null comment '전자기기 유형'")
    val type : ElectronicDeviceType,

    @Column(name = "serialNumber", columnDefinition = "varchar(30) not null comment '전자기기번호'")
    val serialNumber : String,

    @Column(name = "model", columnDefinition = "varchar(60) not null comment '모델'")
    val model : String,

    @Column(name = "manufacturer", columnDefinition = "varchar(60) not null comment '제조사'")
    val manufacturer : String,

    @Column(name = "price", columnDefinition = "int not null comment '가격'")
    val price : Int,

    @Column(name = "description", columnDefinition = "varchar(255) not null comment '설명'")
    val description : String,

) : BaseEntity()
package io.woorinpang.assetservice.storage.db.core.electronic

import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceType
import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicUpdate
import java.math.BigDecimal

@Suppress("ktlint:standard:no-blank-line-in-list")
@Entity
@Table(name = "ElectronicDevice")
@DynamicUpdate
class ElectronicDeviceEntity(
    @Column(name = "assetId", columnDefinition = "bigint not null comment '자산 고유번호'")
    val assetId: Long,

    @Column(name = "electronicDeviceType", columnDefinition = "varchar(30) not null comment '전자기기 타입'")
    @Enumerated(EnumType.STRING)
    val type: ElectronicDeviceType,

    @Column(name = "manufacturer", columnDefinition = "varchar(255) not null comment '제조사'")
    var manufacturer: String,

    @Column(name = "model", columnDefinition = "varchar(255) null comment '모델명'")
    var model: String? = null,

    @Column(name = "serialNumber", columnDefinition = "varchar(255) null comment '시리얼 번호'")
    var serialNumber: String? = null,

    @Column(name = "price", columnDefinition = "decimal default 0 not null comment '가격'")
    var price: BigDecimal,

    @Column(name = "isForSale", columnDefinition = "bit default b'0' not null comment '판매 등록 여부'")
    private var isForSale: Boolean = false,

    @Column(name = "deleted", columnDefinition = "bit default b'0' not null comment '삭제 여부'")
    private var deleted: Boolean = false,

    @Column(name = "createdBy", columnDefinition = "varchar(60) not null comment '생성자'")
    val createdBy: String,

    @Column(name = "updatedBy", columnDefinition = "varchar(60) not null comment '수정자'")
    var updatedBy: String,
) : BaseEntity() {
    companion object {
        fun of(
            assetId: Long,
            type: ElectronicDeviceType,
            manufacturer: String,
            model: String?,
            serialNumber: String?,
            price: BigDecimal,
            createdBy: String,
        ): ElectronicDeviceEntity {
            return ElectronicDeviceEntity(
                assetId = assetId,
                type = type,
                manufacturer = manufacturer,
                model = model,
                serialNumber = serialNumber,
                price = price,
                createdBy = createdBy,
                updatedBy = createdBy,
            )
        }
    }

    fun modify(
        manufacturer: String,
        model: String,
        serialNumber: String,
        price: BigDecimal,
        updatedBy: String,
    ) {
        this.manufacturer = manufacturer
        this.model = model
        this.serialNumber = serialNumber
        this.price = price
        this.updatedBy = updatedBy
    }

    fun delete(updatedBy: String) {
        this.deleted = true
        this.updatedBy = updatedBy
    }

    fun equalCreatedBy(createdBy: String): Boolean = this.createdBy == createdBy
}
